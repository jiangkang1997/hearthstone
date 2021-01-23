package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.core.card.parent.Card;

/**
 * @author jk
 */
public abstract class AbstractBuff implements Buff {

    public AbstractBuff(Card owner,int life){
        this.owner = owner;
        this.life = life;
    }

    /**
     * buff的释放者
     */
    protected Card owner;

    /**
     * buff持续的回合数
     */
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
