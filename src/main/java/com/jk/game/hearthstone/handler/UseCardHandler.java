package com.jk.game.hearthstone.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.common.SpringUtil;
import com.jk.game.hearthstone.config.UseCardPreprocessor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.exception.IllegalOperationException;

import java.util.Map;

/**
 * 掌管整个出牌阶段的生命周期
 *
 * @author jk
 */
public class UseCardHandler {


    public void usrCard(Desktop desktop,Card card, Organism target) throws IllegalOperationException {
        doUseCardPreprocessor(desktop,card,target);
    }

    private void doUseCardPreprocessor(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        Map<String, UseCardPreprocessor> playPreprocessors = SpringUtil.getPlayPreprocessors();
        for (UseCardPreprocessor preprocessor : playPreprocessors.values()) {
            preprocessor.processBeforePlay(desktop,card, target);
        }
    }
}
