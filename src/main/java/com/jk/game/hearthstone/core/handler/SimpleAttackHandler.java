package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;

/**
 * 测试用的简单攻击处理器
 * @author jk
 */
public class SimpleAttackHandler {

    public static void doAttack(Organism attacker,Organism target){
        target.setHealth(target.getHealth() - attacker.getAttack());
        if(target instanceof Minion){
            attacker.setHealth(attacker.getHealth() - target.getAttack());
        }
    }
}
