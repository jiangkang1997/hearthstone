package com.jk.game.hearthstone.enumeration;

/**
 * @author jk
 */
public enum ProcessorType {

    /**
     * 基础处理器（空实现）
     */
    BASE,

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
     * 英雄攻击前置
     */
    PRE_HEROATTACK_SKILL,

    /**
     * 英雄攻击后置
     */
    POST_HEROATTACK_SKILL,

    /**
     * 随从攻击前置
     */
    PRE_MINIONATTACK_SKILL,

    /**
     * 随从攻击后置
     */
    POST_MINIONATTACK_SKILL,

    /**
     * 伤害后置
     */
    POST_HURT,

    /**
     * 治疗后置
     */
    POST_TREAT;
}
