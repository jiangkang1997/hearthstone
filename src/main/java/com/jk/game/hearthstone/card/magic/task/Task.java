package com.jk.game.hearthstone.card.magic.task;

import com.jk.game.hearthstone.card.magic.Magic;

/**
 * @author jk
 */
public class Task extends Magic {

    private Task duplicate;

    @Override
    public Magic clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Task) super.clone();
        }
        return duplicate;
    }
}
