package com.jk.game.hearthstone.card;


import com.jk.game.hearthstone.enumeration.CardOwner;
import lombok.Data;

/**
 * Superclass of all cards
 *
 * @author jk
 */
@Data
public abstract class BaseCard implements Cloneable {

    protected Integer cost;
    protected CardOwner cardOwner;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
