package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;

/**
 * @author jk
 */
public abstract class AbstractProcessor implements Processor {

    private Card owner;
    private AbstractProcessor duplicate;

    @Override
    public Card getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Card owner) {
        this.owner = owner;
    }

    @Override
    public Processor clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (AbstractProcessor) super.clone();
            if(owner != null){
                duplicate.owner = owner.clone();
            }
        }
        return duplicate;
    }
}
