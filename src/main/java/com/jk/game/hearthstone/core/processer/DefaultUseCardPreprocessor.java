package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.magic.Magic;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.Stand;
import com.jk.game.hearthstone.exception.IllegalOperationException;

import java.util.List;

/**
 * 默认的出牌前置处理器，属于炉石的基础规则
 *
 * @author jk
 */
public class DefaultUseCardPreprocessor implements UseCardPreprocessor {

    private static final int MAX_MINION_NUM = 7;
    private static final int MAX_TASK_SECRET_NUM = 5;

    @Override
    public void processBeforePlay(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        //水晶合法性
        powerLegalityCheck(desktop,card,target);
        //目标合法性
        targetLegalityCheck(card, target);
        //随从数量合法性
        minionNumLegalityCheck(desktop,card);
    }

    private void powerLegalityCheck(Desktop desktop, Card card, Organism target) throws IllegalOperationException{
        int cost = card.getCost();
        Player player = desktop.getPlayer(card.getPlayerType());
        if(cost > player.getPower()){
            throw new IllegalOperationException("我无法这么做");
        }
    }


    private void targetLegalityCheck(Card card, Organism target) throws IllegalOperationException{
        TargetScope[] targetScopes = card.getClass().getAnnotationsByType(TargetScope.class);
        Class classScope = null;
        Stand stand = null;
        if(targetScopes != null){
            for (TargetScope targetScope : targetScopes) {
                classScope = targetScope.classScope();
                stand = targetScope.stand();
            }
            if(classScope == Minion.class && target instanceof Hero){
                throw new IllegalOperationException("这不是一个有效的目标");
            }else if(classScope == Hero.class && target instanceof Minion){
                throw new IllegalOperationException("这不是一个有效的目标");
            }else if(stand == Stand.FOE && target.getCardType() == card.getCardType()){
                throw new IllegalOperationException("这不是一个有效的目标");
            }else if(stand == Stand.FRIEND && target.getCardType() != card.getCardType()){
                throw new IllegalOperationException("这不是一个有效的目标");
            }
        }
        //todo: 英雄技能和指向性法术无法指向魔免随从以及 处于无敌状态的英雄和随从
    }

    private void minionNumLegalityCheck(Desktop desktop, Card card) throws IllegalOperationException{
        List<Minion> minions = desktop.getMinions(card.getPlayerType());
        if(minions.size() == MAX_MINION_NUM){
            throw new IllegalOperationException("无法拥有更多随从");
        }
        List<Magic> tasksAndSecrets = desktop.getTasksAndSecrets(card.getPlayerType());
        if(tasksAndSecrets.size() >= MAX_TASK_SECRET_NUM){
            throw new IllegalOperationException("无法拥有更多奥秘和任务");
        }
    }
}
