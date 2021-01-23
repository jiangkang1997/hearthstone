package com.jk.game.hearthstone.core.config;

import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.data.Desktop;

/**
 * 连击
 * @author jk
 */
public interface Combo {

    /**
     * 连击
     * @param desktop
     * @param target
     */
    void combo(Desktop desktop, Organism target);
}
