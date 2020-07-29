package com.jk.game.hearthstone.config;

import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;

/**
 * 战吼随从通过实现此接口来实现战吼效果
 *
 * @author jk
 */
public interface BattleCry {

    /**
     * 战吼效果
     * @param desktop 游戏环境
     * @param target  战吼目标
     */
    void effect(Desktop desktop, Organism target);
}
