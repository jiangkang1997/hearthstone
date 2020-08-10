package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;

/**
 * @author jk
 */
public abstract class AbstractBuff implements Buff {

    protected Card owner;
    protected int life = 0;

    @Override
    public Card getOwner() {
        return owner;
    }


    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void spendLife() {
        life--;
    }
}
