package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.data.Turn;

/**
 * 默认的出牌后置处理器
 *
 * @author jk
 */
public class DefaultUseCardPostProcessor extends AbstractUseCardPostProcessor {

    @Override
    public void processAfterPlay(Desktop desktop, Card card){
        Turn currentTurn = desktop.getHistory().getCurrentTurn();
        currentTurn.setUseNum(currentTurn.getUseNum() + 1);
    }

}
