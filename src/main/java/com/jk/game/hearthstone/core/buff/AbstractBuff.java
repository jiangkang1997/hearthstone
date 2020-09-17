package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.card.Card;

/**
 * @author jk
 */
public abstract class AbstractBuff implements Buff {

    /**
     * buff的释放者
     */
    protected Card owner;

    /**
     * buff持续的回合数
     */
    protected int life = 0;

    private AbstractBuff duplicate;

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

    @Override
    public AbstractBuff clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (AbstractBuff) super.clone();
            if(owner != null){
                duplicate.owner = owner.clone();
            }
        }
        return duplicate;
    }
}
