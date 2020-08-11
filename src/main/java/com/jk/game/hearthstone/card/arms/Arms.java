package com.jk.game.hearthstone.card.arms;

import com.jk.game.hearthstone.card.Card;
import lombok.Getter;
import lombok.Setter;

/**
 * Superclass of all arms
 * @author jk
 */

@Getter
@Setter
public class Arms extends Card implements Cloneable {

    protected Integer attack;
    protected Integer durable;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
