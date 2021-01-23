package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;

/**
 * @author jk
 */
public abstract class AbstractProcessor implements Processor {

    private final Card owner;

    public AbstractProcessor(Card owner){
        this.owner = owner;
    }

    @Override
    public Card getOwner() {
        return owner;
    }
}
