package com.jk.game.hearthstone.card.magic;

import com.jk.game.hearthstone.card.Card;

/**
 * 所有的法术牌的基类
 * @author jk
 */
public class Magic extends Card {

    /**
     * 副本
     */
    private Magic duplicate;

    @Override
    public Magic clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Magic) super.clone();
        }
        return duplicate;
    }
}
