package com.jk.game.hearthstone.card.organism;


import com.jk.game.hearthstone.card.BaseCard;

/**
 * Superclass of all organisms
 *
 * @author jk
 */
public class BaseOrganism extends BaseCard implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
