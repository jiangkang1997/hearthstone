package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.Stand;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * @author jk
 * @date 2021/1/10 20:59
 */
public class DefaultHeroSkillPreprocessor extends AbstractHeroSkillPreprocessor {

    public DefaultHeroSkillPreprocessor(Card owner) {
        super(owner);
    }

    @Override
    public void doHeroSkillPreprocessor(Desktop desktop, Hero hero, Organism target) throws IllegalOperationException {
        //法力值判断
        powerLegalityCheck(desktop,hero);
        //目标合法性
        targetLegalityCheck(hero, target);
    }

    private void powerLegalityCheck(Desktop desktop,Hero hero) throws IllegalOperationException{
        int cost = hero.getHeroSkill().getSkillCost();
        Player player = desktop.getPlayer(hero.getPlayerType());
        if(cost > player.getPower()){
            throw new IllegalOperationException("法力值不够");
        }
    }

    private void targetLegalityCheck(Hero hero, Organism target) throws IllegalOperationException{
        TargetScope[] targetScopes = hero.getHeroSkill().getClass().getAnnotationsByType(TargetScope.class);
        Class classScope = null;
        Stand stand = null;
        if(targetScopes != null && targetScopes.length > 0){
            for (TargetScope targetScope : targetScopes) {
                classScope = targetScope.classScope();
                stand = targetScope.stand();
            }
            if(classScope == Minion.class && target instanceof Hero){
                throw new IllegalOperationException("这不是一个有效的目标");
            }else if(classScope == Hero.class && target instanceof Minion){
                throw new IllegalOperationException("这不是一个有效的目标");
            }else if(stand == Stand.FOE && target.getCardType() == hero.getCardType()){
                throw new IllegalOperationException("这不是一个有效的目标");
            }else if(stand == Stand.FRIEND && target.getCardType() != hero.getCardType()){
                throw new IllegalOperationException("这不是一个有效的目标");
            }
        }
        //todo: 英雄技能无法指向魔免随从以及 处于无敌状态的英雄和随从
    }
}
