package com.jk.game.hearthstone.config;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;

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
