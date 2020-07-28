package com.jk.game.hearthstone.card.organism;


import com.jk.game.hearthstone.card.Card;

/**
 * Superclass of all organisms
 *
 * @author jk
 */
public class Organism extends Card implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
