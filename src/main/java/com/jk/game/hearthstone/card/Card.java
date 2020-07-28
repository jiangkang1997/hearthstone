package com.jk.game.hearthstone.card;


import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import lombok.Data;

/**
 * Superclass of all cards
 *
 * @author jk
 */
@Data
public class Card implements Cloneable {

    protected Integer cost;
    protected CardType cardType;
    protected PlayerType playerType;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
