package com.jk.game.hearthstone.card.magic.secret;

import com.jk.game.hearthstone.card.magic.Magic;
import com.jk.game.hearthstone.card.magic.task.Task;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 所有奥秘的基类
 *
 * @author jk
 */
public class Secret extends Magic {

    public Secret(Desktop desktop, int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }

    private Secret duplicate;

    @Override
    public Secret clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Secret) super.clone();
        }
        return duplicate;
    }
}
