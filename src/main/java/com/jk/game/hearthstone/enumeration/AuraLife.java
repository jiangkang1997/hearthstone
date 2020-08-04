package com.jk.game.hearthstone.enumeration;

/**
 * 光环的持续时间
 *
 * @author jk
 */
public enum  AuraLife {

    /**
     * 当前回合
     */
    AURA_LIFE_ONE_TURN,

    /**
     * 两个回合
     */
    AURA_LIFE_TWO_TURN,

    /**
     * 永久有效
     */
    AURA_LIFE_FOREVER,

    /**
     * 依赖于光环的拥有者
     */
    AURA_LIFE_DEPEND;
}
