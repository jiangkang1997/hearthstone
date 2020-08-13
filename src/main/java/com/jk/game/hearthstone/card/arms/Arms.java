package com.jk.game.hearthstone.card.arms;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.magic.normal.NormalMagic;
import com.jk.game.hearthstone.data.Desktop;
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
