package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.data.History;

/**
 * 测试用的简单攻击处理器
 * @author jk
 */
public class SimpleAttackHandler {

    public static void doAttack(Desktop desktop,Organism attacker, Organism target){
        target.setHealth(target.getHealth() - attacker.getAttack());
        if(target instanceof Minion){
            attacker.setHealth(attacker.getHealth() - target.getAttack());
        }
        //当前回合的攻击次数+1
        attacker.setAttackTime(attacker.getAttackTime() + 1);
        if(!(attacker.isWindfury() && attacker.getAttackTime()<2)){
            attacker.setCanAttack(false);
        }

        if(target instanceof Minion && target.getHealth() < 0){
            desktop.getMinions(target.getPlayerType()).remove((Minion) target);
        }
    }
}
