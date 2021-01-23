package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;

/**
 * 测试用的简单攻击处理器
 * @author jk
 */
public class SimpleAttackHandler {

    public static void doAttack(Desktop desktop,Organism attacker, Organism target){
        HurtHandler.doHurt(desktop,attacker,target,attacker.getAttack());
        if(target instanceof Minion){
            HurtHandler.doHurt(desktop,target,attacker,target.getAttack());
        }
        //当前回合的攻击次数+1
        attacker.setAttackTime(attacker.getAttackTime() + 1);
        if(!(attacker.isWindfury() && attacker.getAttackTime()<2)){
            attacker.setCanAttack(false);
        }
        DeathHandler.doDeathHandler(desktop);
    }
}
