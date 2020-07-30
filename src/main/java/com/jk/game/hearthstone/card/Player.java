package com.jk.game.hearthstone.card;

import com.jk.game.hearthstone.card.arms.Arms;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import lombok.Data;

/**
 * @author jk
 */
@Data
public class Player implements Cloneable {

    /**
     * 当前水晶数量
     */
    private int power;

    /**
     * 最大水晶数量
     */
    private int maxPower;

    /**
     * 当前回合过载水晶数量
     */
    private int overloadPower;

    /**
     * 下回合的过载水晶数量
     */
    private int overloadPowerNextTurn;

    /**
     * 当前英雄
     */
    private Hero hero;

    /**
     * 当前武器
     */
    private Arms arms;

    public void costPower(int cost,int overload) throws IllegalOperationException {
        if(power - cost < 0){
            throw new IllegalOperationException("我需要更多的法力值");
        }
        power = power - cost;
        overloadPowerNextTurn = overloadPowerNextTurn + overload;
    }



    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result = super.clone();
        if(hero != null){
            ((Player) result).hero = (Hero) hero.clone();
        }
        if(arms != null){
            ((Player) result).arms = (Arms) arms.clone();
        }
        return result;
    }

}
