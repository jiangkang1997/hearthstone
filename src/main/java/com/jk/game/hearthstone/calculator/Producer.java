package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.core.processer.AbstractAttackPreProcessor;
import com.jk.game.hearthstone.core.processer.AbstractHeroSkillPreprocessor;
import com.jk.game.hearthstone.core.processer.AbstractUseCardPreprocessor;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.data.Action;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ActionType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为的生产者，用于判断当前条件下，可以做出的所有动作
 *
 * @author jk
 */
public class Producer {

    /**
     * 获取当前状态下，所有的动作可能
     *
     * @param desktop
     * @return 包含所有信息
     */
    public static List<Action> getPossibleAction(Desktop desktop, PlayerType playerType, boolean ignoreSeat) {
        List<Action> actions = new ArrayList<>();
        //手牌动作
        actions.addAll(cardAction(desktop, playerType, ignoreSeat));
        //随从动作
        actions.addAll(entourageAction(desktop, playerType));
        //英雄攻击
        actions.addAll(heroAttackAction(desktop, playerType));
        //英雄技能
        actions.addAll(heroSkillAction(desktop, playerType));
        return actions;
    }

    private static List<Action> cardAction(Desktop desktop, PlayerType playerType, boolean ignoreSeat) {
        List<Action> actions = new ArrayList<>();
        int minionSize = desktop.getMinions(playerType).getList().size();
        //遍历手牌
        for (Card card : desktop.getCards(playerType).getList()) {
            //通过出牌前置处理器过滤不合法的出牌动作
            List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_USE_CARD);
            for (Processor processor : processors) {
                //有指向性目标的卡牌，遍历所有可能的目标
                if (card.getClass().getAnnotationsByType(TargetScope.class).length != 0) {
                    List<Organism> allTarget = getAllTarget(desktop);
                    for (Organism target : allTarget) {
                        try {
                            ((AbstractUseCardPreprocessor) processor).processBeforePlay(desktop, card, target);
                        } catch (IllegalOperationException e) {
                            continue;
                        }
                        actions.add(new Action(ActionType.ACTION_TYPE_USE, card, target));
                    }
                }
                // 无目标的卡牌
                else {
                    try {
                        ((AbstractUseCardPreprocessor) processor).processBeforePlay(desktop, card, null);
                    } catch (IllegalOperationException e) {
                        continue;
                    }
                    actions.add(new Action(ActionType.ACTION_TYPE_USE, card));
                }
            }
        }
        //遍历随从的站位
        List<Action> actionsWithSeat = new ArrayList<>();
        if (!ignoreSeat && actions.size() > 0) {
            for (Action action : actions) {
                if(!(action.getCard() instanceof Minion)){
                    continue;
                }
                for (int seat = 0; seat < minionSize; seat++) {
                    actionsWithSeat.add(new Action(action.getActionType(), action.getCard(), action.getTarget(), seat));
                }
            }
        }
        actions.addAll(actionsWithSeat);
        return actions;
    }

    private static List<Action> entourageAction(Desktop desktop, PlayerType playerType) {
        List<Action> actions = new ArrayList<>();
        //todo: 攻击的前置拦截
        for (Minion minion : desktop.getMinions(playerType).getList()) {
            for (Minion foeMinion : desktop.getMinions(playerType.getOpponentType()).getList()) {
                actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, minion, foeMinion));
            }
            actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, minion, desktop.getPlayer(playerType.getOpponentType()).getHero()));
        }
        //过滤非法操作
        List<Processor> attackPerProcessors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_ATTACK);
        List<Action> illegalAction = new ArrayList<>();
        if (!CollectionUtils.isEmpty(actions)) {
            for (Action action : actions) {
                for (Processor attackPerProcessor : attackPerProcessors) {
                    try {
                        ((AbstractAttackPreProcessor) attackPerProcessor).processBeforeHeroAttack(desktop, (Organism) action.getCard(), action.getTarget());
                    } catch (IllegalOperationException e) {
                        illegalAction.add(action);
                    }
                }
            }
        }
        actions.removeAll(illegalAction);
        return actions;
    }

    private static List<Action> heroAttackAction(Desktop desktop, PlayerType playerType) {
        List<Action> actions = new ArrayList<>();
        //英雄攻击
        Player player = desktop.getPlayer(playerType);
        Hero hero = player.getHero();

        for (Minion foeMinion : desktop.getMinions(playerType.getOpponentType()).getList()) {
            actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, hero, foeMinion));
        }
        actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, hero, desktop.getPlayer(playerType.getOpponentType()).getHero()));
        //过滤非法操作
        List<Processor> attackPerProcessors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_ATTACK);
        List<Action> illegalAction = new ArrayList<>();
        if (!CollectionUtils.isEmpty(actions)) {
            for (Action action : actions) {
                for (Processor attackPerProcessor : attackPerProcessors) {
                    try {
                        ((AbstractAttackPreProcessor) attackPerProcessor).processBeforeHeroAttack(desktop, hero, action.getTarget());
                    } catch (IllegalOperationException e) {
                        illegalAction.add(action);
                    }
                }
            }
        }
        actions.removeAll(illegalAction);
        return actions;
    }

    private static List<Action> heroSkillAction(Desktop desktop, PlayerType playerType) {
        Hero hero = desktop.getPlayer(playerType).getHero();
        List<Action> actions = new ArrayList<>();
        if (hero.getCanSkill()) {
            //有指向目标的技能
            if (hero.getHeroSkill().getClass().getAnnotationsByType(TargetScope.class).length > 0) {
                List<Organism> allTarget = getAllTarget(desktop);
                for (Organism target : allTarget) {
                    actions.add(new Action(ActionType.ACTION_TYPE_SKILL, hero, target));
                }
            }
            //无目标的技能
            else {
                actions.add(new Action(ActionType.ACTION_TYPE_SKILL, hero));
            }
            List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_HERO_SKILL);
            List<Action> illegalAction = new ArrayList<>();
            if (!CollectionUtils.isEmpty(actions)) {
                for (Action action : actions) {
                    for (Processor processor : processors) {
                        try {
                            ((AbstractHeroSkillPreprocessor) processor).doHeroSkillPreprocessor(desktop, hero, action.getTarget());
                        } catch (IllegalOperationException e) {
                            illegalAction.add(action);
                        }
                    }
                }
            }
            actions.removeAll(illegalAction);
        }
        return actions;
    }

    private static List<Organism> getAllTarget(Desktop desktop) {
        List<Organism> targets = new ArrayList<>();
        targets.addAll(desktop.getMainMinions().getList());
        targets.addAll(desktop.getSecondMinions().getList());
        targets.add(desktop.getMainPlayer().getHero());
        targets.add(desktop.getSecondPlayer().getHero());
        targets.add(null);
        return targets;
    }

}
