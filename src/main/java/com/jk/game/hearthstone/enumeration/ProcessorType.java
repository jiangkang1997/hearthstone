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
    POST_JOIN;
}
