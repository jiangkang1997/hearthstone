package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;

/**
 * @author jk
 */
public abstract class AbstractProcessor implements Processor {

    private Card owner;

    @Override
    public Card getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Card owner) {
        this.owner = owner;
    }
}
