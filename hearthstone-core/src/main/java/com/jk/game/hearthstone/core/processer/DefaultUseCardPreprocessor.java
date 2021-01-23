package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.annotation.TargetScope;
import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.Player;
import com.jk.game.hearthstone.core.card.parent.magic.Magic;
import com.jk.game.hearthstone.core.card.parent.magic.Secret;
import com.jk.game.hearthstone.core.card.parent.magic.Task;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.common.MinionCollection;
import com.jk.game.hearthstone.core.config.Conditional;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.Stand;
import com.jk.game.hearthstone.core.exception.IllegalOperationException;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 默认的出牌前置处理器，属于炉石的基础规则
 *
 * @author jk
 */
public class DefaultUseCardPreprocessor extends AbstractUseCardPreprocessor {

    private static final int MAX_MINION_NUM = 7;
    private static final int MAX_TASK_SECRET_NUM = 5;

    public DefaultUseCardPreprocessor(Card owner) {
        super(owner);
    }

    @Override
    public void processBeforePlay(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        //水晶合法性
        powerLegalityCheck(desktop, card);
        //目标合法性
        targetLegalityCheck(card, target);
        //随从数量合法性
        if(card instanceof Minion){
            minionNumLegalityCheck(desktop, (Minion) card);
        }
        //任务奥秘数量及重复性判断
        if(card instanceof Task || card instanceof Secret){
            taskAndSecretCheck(desktop, (Magic) card);
        }
        //特殊判断
        if (card instanceof Conditional) {
            conditionCheck(desktop, card);
        }
    }

    private void powerLegalityCheck(Desktop desktop, Card card) throws IllegalOperationException {
        //todo: 血色绽放
        int cost = card.getCost();
        Player player = desktop.getPlayer(card.getPlayerType());
        if (cost > player.getPower()) {
            throw new IllegalOperationException("我无法这么做");
        }
    }


    private void targetLegalityCheck(Card card, Organism target) throws IllegalOperationException {
        TargetScope[] targetScopes;
        if(card instanceof Hero){
            targetScopes = ((Hero)card).getHeroSkill().getClass().getAnnotationsByType(TargetScope.class);
        }else {
            targetScopes = card.getClass().getAnnotationsByType(TargetScope.class);
        }
        Class<?> classScope = null;
        Stand stand = null;
        if (targetScopes.length > 0) {
            for (TargetScope targetScope : targetScopes) {
                classScope = targetScope.classScope();
                stand = targetScope.stand();
            }
            if(target != null){
                if (classScope == Minion.class && target instanceof Hero) {
                    throw new IllegalOperationException("这不是一个有效的目标");
                } else if (classScope == Hero.class && target instanceof Minion) {
                    throw new IllegalOperationException("这不是一个有效的目标");
                } else if (stand == Stand.FOE && target.getPlayerType() == card.getPlayerType()) {
                    throw new IllegalOperationException("这不是一个有效的目标");
                } else if (stand == Stand.FRIEND && target.getPlayerType() != card.getPlayerType()) {
                    throw new IllegalOperationException("这不是一个有效的目标");
                }
            }
            else {
                //带指向性效果的非随从牌 无法指向空目标
                if(!( card instanceof Minion)){
                    throw new IllegalOperationException("必须选择一个目标");
                }
                //判断是否存在符合条件的目标
                MinionCollection friendMinion = card.getDesktop().getMinions(card.getPlayerType());
                MinionCollection foeMinion = card.getDesktop().getMinions(card.getPlayerType().getOpponentType());
                if(classScope == Organism.class || classScope == Hero.class){
                    throw new IllegalOperationException("必须选择一个目标");
                }
                else if(stand == Stand.FRIEND && !CollectionUtils.isEmpty(friendMinion.getList())){
                    throw new IllegalOperationException("必须选择一个目标");
                }
                else if(stand == Stand.FOE && !CollectionUtils.isEmpty(foeMinion.getList())){
                    throw new IllegalOperationException("必须选择一个目标");
                }
                else if(stand == Stand.ALL &&
                        (!CollectionUtils.isEmpty(friendMinion.getList()) || !CollectionUtils.isEmpty(foeMinion.getList()))){
                    throw new IllegalOperationException("必须选择一个目标");
                }
            }

        }
        //todo: 英雄技能和指向性法术无法指向魔免随从以及 处于无敌状态的英雄和随从
    }

    private void minionNumLegalityCheck(Desktop desktop, Minion minion) throws IllegalOperationException {
        MinionCollection minions = desktop.getMinions(minion.getPlayerType());
        if (minions.getList().size() == MAX_MINION_NUM) {
            throw new IllegalOperationException("无法拥有更多随从");
        }
    }

    private void taskAndSecretCheck(Desktop desktop,Magic card) throws IllegalOperationException {
        List<Magic> tasksAndSecrets = desktop.getTasksAndSecrets(card.getPlayerType());
        if (tasksAndSecrets.size() >= MAX_TASK_SECRET_NUM) {
            throw new IllegalOperationException("无法拥有更多奥秘和任务");
        }
        if(!CollectionUtils.isEmpty(tasksAndSecrets)){
            for (Magic tasksAndSecret : tasksAndSecrets) {
                if(tasksAndSecret.getClass() == card.getClass()){
                    throw new IllegalOperationException("无法拥有多个相同的奥秘或任务");
                }
            }
        }
    }

    private void conditionCheck(Desktop desktop, Card card) throws IllegalOperationException {
        boolean condition = ((Conditional) card).condition(desktop);
        if (!condition) {
            throw new IllegalOperationException("无法使用");
        }
    }
}
