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
    POST_HERO_SKILL;
}
