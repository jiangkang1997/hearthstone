package com.jk.game.hearthstone.core.card.parent;

import com.jk.game.hearthstone.core.card.parent.arms.Arms;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.exception.IllegalOperationException;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author jk
 */
@Getter
@Setter
public class Player implements Serializable {

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

    public void costPower(int cost, int overload) throws IllegalOperationException {
        if (power - cost < 0) {
            throw new IllegalOperationException("我需要更多的法力值");
        }
        power = power - cost;
        overloadPowerNextTurn = overloadPowerNextTurn + overload;
    }
}
