package com.jk.game.hearthstone.card.parent.arms;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
import lombok.Setter;

/**
 * Superclass of all arms
 * @author jk
 */

@Getter
@Setter
public class Arms extends Card{

    protected Integer attack;
    protected Integer durable;

    public Arms(Desktop desktop, int cost, String name, String desc, CardType cardType) {
        super(desktop, cost, name, desc, cardType);
    }
}
