package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.data.Desktop;

import java.util.List;

/**
 * 弃牌操作执行者
 *
 * @author jk
 */
public class DiscardCardHandler {

    public static void discardCard(Desktop desktop, Card card){
        List<Card> cards = desktop.getCards(card.getPlayerType());
        cards.remove(card);
        doDisCardPostProcessor();
    }

    private static void doDisCardPostProcessor(){
        //todo：弃牌事件后置处理器
    }
}
