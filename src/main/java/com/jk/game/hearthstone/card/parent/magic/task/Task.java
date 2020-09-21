package com.jk.game.hearthstone.card.parent.magic.task;

import com.jk.game.hearthstone.card.parent.magic.Magic;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * @author jk
 */
public class Task extends Magic {

    public Task(Desktop desktop, int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }

    private Task duplicate;

    @Override
    public Magic clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Task) super.clone();
        }
        return duplicate;
    }
}
