package com.jk.game.hearthstone.card.parent.arms;

import com.jk.game.hearthstone.card.parent.Card;
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

    /**
     * 副本
     */
    private Arms duplicate;

    @Override
    public Arms clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Arms) super.clone();
        }
        return duplicate;
    }
}
