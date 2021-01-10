package com.jk.game.hearthstone.config;

import com.jk.game.hearthstone.data.Desktop;

/**
 * 出牌的前置判断
 * @author jk
 */
public interface Conditional {

    /**
     * 对于某些存在特殊条件才允许打出的卡牌，实现某方法。
     * 例如 《致命药膏》在英雄没有装备武器时 无法使用
     * @param desktop
     * @return
     */
    boolean condition(Desktop desktop);
}
