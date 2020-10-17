package com.jk.game.hearthstone.card.parent.magic;

import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 所有奥秘的基类
 *
 * @author jk
 */
public class Secret extends Magic {

    public Secret(Desktop desktop, int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }
}
