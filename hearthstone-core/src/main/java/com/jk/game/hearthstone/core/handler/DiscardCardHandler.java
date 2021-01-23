package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.common.CardCollection;
import com.jk.game.hearthstone.core.data.Desktop;

/**
 * 弃牌操作执行者
 *
 * @author jk
 */
public class DiscardCardHandler {

    public static void discardCard(Desktop desktop, Card card){
        CardCollection cards = desktop.getCards(card.getPlayerType());
        cards.remove(card);
        doDisCardPostProcessor();
    }

    private static void doDisCardPostProcessor(){
        //todo：弃牌事件后置处理器
    }
}
