package com.jk.game.hearthstone.core.card.parent.magic;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;

/**
 * 所有的法术牌的基类
 * @author jk
 */
public class Magic extends Card {

    public Magic(Desktop desktop,int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }
}
