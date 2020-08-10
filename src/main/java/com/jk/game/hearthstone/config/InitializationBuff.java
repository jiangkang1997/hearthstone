package com.jk.game.hearthstone.config;

import com.jk.game.hearthstone.data.Desktop;

/**
 * 初始化buff，随从入场时判断场上环境来生成buff
 * 例如 ：南海船工
 *
 * @author jk
 */
public interface InitializationBuff {

    /**
     * 生成buff
     * @param desktop 游戏环境
     */
    void generateBuff(Desktop desktop);
}
