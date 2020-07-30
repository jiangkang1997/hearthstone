package com.jk.game.hearthstone.core.processer;


import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;

/**
 * The class that implements this interface is considered a PlayPostProcess
 * Any play operation will trigger the execution of the processAfterPlay method.
 *
 * @author jk
 */
public abstract class AbstractUseCardPostProcessor extends AbstractProcessor {

    public final ProcessorType PROCESSOR_TYPE = ProcessorType.PRE_USE_CARD;

    /**
     * Triggered after the card is played
     * @param desktop
     * @param card
     */
    public abstract void processAfterPlay(Desktop desktop, Card card);
}