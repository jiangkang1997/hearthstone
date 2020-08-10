package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.enumeration.BuffType;

/**
 * buff类的统一接口
 *
 * @author jk
 */
public interface Buff {

    /**
     * 获取buff的释放者
     *
     * @return buff的释放者
     */
    Card getOwner();


    /**
     * 获取buff的类型
     *
     * @return buff类型
     */
    BuffType getBuffType();

    /**
     * 获取buff的持续时间
     *
     * @return buff的持续时间
     */
    int getLife();

    /**
     * buff持续时间减一回合
     */
    void spendLife();
}
