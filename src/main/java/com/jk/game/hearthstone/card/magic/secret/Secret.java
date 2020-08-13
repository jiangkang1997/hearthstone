package com.jk.game.hearthstone.card.magic.secret;

import com.jk.game.hearthstone.card.magic.Magic;
import com.jk.game.hearthstone.card.magic.task.Task;

/**
 * 所有奥秘的基类
 *
 * @author jk
 */
public class Secret extends Magic {

    private Secret duplicate;

    @Override
    public Secret clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Secret) super.clone();
        }
        return duplicate;
    }
}
