package com.jk.game.hearthstone.card.arms;

import com.jk.game.hearthstone.card.BaseCard;
import lombok.Getter;
import lombok.Setter;

/**
 * Superclass of all arms
 * @author jk
 */

@Getter
@Setter
public abstract class BaseArms extends BaseCard implements Cloneable {

    protected Integer att;
    protected Integer durable;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
