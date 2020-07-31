package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.enumeration.ProcessorType;

/**
 * @author jk
 */
public abstract class AbstractProcessor implements Processor {

    private Card owner;
    private final ProcessorType PROCESS_TYPE = ProcessorType.BASE;

    @Override
    public Card getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Card owner) {
        this.owner = owner;
    }

    @Override
    public ProcessorType getProcessorType() {
        return PROCESS_TYPE;
    }
}
