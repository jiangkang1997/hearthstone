package com.jk.game.hearthstone.card.organism.entourage;


import com.jk.game.hearthstone.card.organism.BaseOrganism;

/**
 * Superclass of all entourages
 *
 * @author jk
 */
public abstract class BaseEntourage extends BaseOrganism implements Cloneable {



    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
