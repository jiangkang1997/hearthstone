package com.jk.game.hearthstone.core.enumeration;

/**
 * @author jk
 */
public enum ProcessorType {


    /**
     * 出牌前置处理
     */
    PRE_USE_CARD,

    /**
     * 出牌后置处理
     */
    POST_USE_CARD,

    /**
     * 入场后置
     */
    POST_JOIN,

    /**
     * 英雄技能前置
     */
    PRE_HERO_SKILL,

    /**
     * 英雄技能后置
     */
    POST_HERO_SKILL,

    /**
     * 攻击前置
     */
    PRE_ATTACK,


    /**
     * 伤害后置
     */
    POST_HURT,

    /**
     * 治疗后置
     */
    POST_TREAT,
    /**
     * 回合结束后置
     */
    POST_END_ROUND;
}
