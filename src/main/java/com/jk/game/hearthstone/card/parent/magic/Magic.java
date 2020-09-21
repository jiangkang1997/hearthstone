package com.jk.game.hearthstone.card.parent.magic;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 所有的法术牌的基类
 * @author jk
 */
public class Magic extends Card {

    public Magic(Desktop desktop,int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }
    /**
     * 副本
     */
    private Magic duplicate;

    @Override
    public Magic clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Magic) super.clone();
        }
        return duplicate;
    }
}
