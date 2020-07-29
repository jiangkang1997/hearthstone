package com.jk.game.hearthstone.core.processer;


/**
 * The class that implements this interface is considered a PlayPostProcess
 * Any play operation will trigger the execution of the processAfterPlay method.
 *
 * @author jk
 */
public interface UseCardPostProcessor extends Processor {

    /**
     *  Triggered after the card is played
     */
    void processAfterPlay();
}
