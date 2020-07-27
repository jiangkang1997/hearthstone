package com.jk.game.hearthstone.config;


/**
 * The class that implements this interface is considered a PlayPostProcess
 * Any play operation will trigger the execution of the processAfterPlay method.
 *
 * @author jk
 */
public interface PlayPostProcessor {

    /**
     *  Triggered after the card is played
     */
    void processAfterPlay();
}
