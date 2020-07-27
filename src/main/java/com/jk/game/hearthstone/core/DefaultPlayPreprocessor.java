package com.jk.game.hearthstone.core;

import com.jk.game.hearthstone.config.PlayPreprocessor;

/**
 * @author jk
 */
public class DefaultPlayPreprocessor implements PlayPreprocessor {


    @Override
    public boolean processBeforePlay() {
        return false;
    }
}
