package com.jk.game.hearthstone.core.card.parent.magic;

import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;

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
