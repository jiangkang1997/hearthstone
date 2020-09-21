package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
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
    public static List<Action> getPossibleAction(Desktop desktop, PlayerType playerType) {
        List<Action> actions = new ArrayList<>();
        //手牌动作
        actions.addAll(cardAction(desktop, playerType));
        //随从动作
        actions.addAll(entourageAction(desktop, playerType));
        //英雄攻击
        actions.addAll(heroAttackAction(desktop, playerType));
        //英雄技能
        actions.addAll(heroSkillAction(desktop, playerType));
        return actions;
    }

    private static List<Action> cardAction(Desktop desktop, PlayerType playerType) {
        List<Action> actions = new ArrayList<>();
        //遍历手牌
        for (Card card : desktop.getCards(playerType)) {
            //通过出牌前置处理器过滤不合法的出牌动作
            List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_USE_CARD);
            for (Processor processor : processors) {
                //有指向性目标的卡牌，遍历所有可能得目标
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
        return actions;
    }

    private static List<Action> entourageAction(Desktop desktop, PlayerType playerType) {
        List<Action> actions = new ArrayList<>();
        //todo: 攻击的前置拦截
        for (Minion minion : desktop.getMinions(playerType)) {
            if (minion.getCanAttack()) {
                for (Minion foeMinion : desktop.getMinions(playerType.getOpponentType())) {
                    actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, minion, foeMinion));
                }
                actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, minion, desktop.getPlayer(playerType.getOpponentType()).getHero()));
            }
        }
        return actions;
    }

    private static List<Action> heroAttackAction(Desktop desktop, PlayerType playerType) {
        List<Action> actions = new ArrayList<>();
        //英雄攻击
        //todo: 攻击的前置拦截
        Player player = desktop.getPlayer(playerType);
        Hero hero = player.getHero();
        if (hero.getCanAttack()) {
            int att = hero.getAttack();
            //英雄攻击力大于0才能攻击
            if (att > 0) {
                for (Minion foeMinion : desktop.getMinions(playerType.getOpponentType())) {
                    actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, hero, foeMinion));
                }
                actions.add(new Action(ActionType.ACTION_TYPE_ATTACK, hero, desktop.getPlayer(playerType.getOpponentType()).getHero()));
            }
        }
        return actions;
    }

    private static List<Action> heroSkillAction(Desktop desktop, PlayerType playerType) {
        Hero hero = desktop.getPlayer(playerType).getHero();
        List<Action> actions = new ArrayList<>();
        if (hero.getCanSkill()) {
            List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_HERO_SKILL);
            if (!CollectionUtils.isEmpty(processors)) {
                //英雄技能的前置拦截
                for (Processor processor : processors) {
                    //有指向目标的技能
                    if (hero.getClass().getAnnotationsByType(TargetScope.class).length > 0) {
                        List<Organism> allTarget = getAllTarget(desktop);
                        for (Organism target : allTarget) {
                            try {
                                ((AbstractHeroSkillPreprocessor) processor).doHeroSkillPreprocessor(desktop, hero, target);
                            } catch (IllegalOperationException e) {
                                continue;
                            }
                            actions.add(new Action(ActionType.ACTION_TYPE_SKILL, hero, target));
                        }
                    }
                    //无目标的技能
                    else {
                        try {
                            ((AbstractHeroSkillPreprocessor) processor).doHeroSkillPreprocessor(desktop, hero, null);
                        } catch (IllegalOperationException e) {
                            continue;
                        }
                        actions.add(new Action(ActionType.ACTION_TYPE_SKILL, hero));
                    }
                }
            }
        }
        return actions;
    }

    private static List<Organism> getAllTarget(Desktop desktop) {
        List<Organism> targets = new ArrayList<>();
        targets.addAll(desktop.getMainMinions());
        targets.addAll(desktop.getSecondMinions());
        targets.add(desktop.getMainPlayer().getHero());
        targets.add(desktop.getSecondPlayer().getHero());
        return targets;
    }

}
