package com.jk.game.hearthstone.config;

/**
 * The class that implements this interface is considered a PlayPreProcessor
 * Any play operation will trigger the execution of the processAfterPlay method.
 *
 * @author jk
 */
public interface PlayPreprocessor {

    /**
     *  Triggered before the card is played
     *  Mainly used to verify the necessary conditions for playing cards
     *
     * @return Is the play operation legal
     */
    boolean processBeforePlay();
}
