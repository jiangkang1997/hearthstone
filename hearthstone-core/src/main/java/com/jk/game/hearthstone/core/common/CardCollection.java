package com.jk.game.hearthstone.core.common;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.enumeration.PlayerType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jk
 * @date 2021/1/4 22:53
 */
public class CardCollection implements Serializable {

    private final List<Card> list = new ArrayList<>();

    private final PlayerType playerType;

    private static int maxCard = 10;

    public CardCollection(PlayerType playerType){
        this.playerType = playerType;
    }

    public void add(Card card){
        if (list.size() < maxCard){
            card.setPlayerType(playerType);
            list.add(card);
        }
    }

    public void remove(Card card){
        list.remove(card);
    }

    public static void setMaxCard(int maxCard) {
        CardCollection.maxCard = maxCard;
    }

    @Deprecated
    public List<Card> getList() {
        return list;
    }

    public Iterator<Card> iterator(){
        return list.iterator();
    }
}
