package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.enumeration.BuffType;

/**
 *
 *
 * @author jk
 */
public abstract class AbstractAttackBuff extends AbstractBuff {

    private static final BuffType BUFF_TYPE = BuffType.BUFF_TYPE_ATTACK;

    protected int attackNum;

    @Override
    public BuffType getBuffType() {
        return BUFF_TYPE;
    }

    public int getAttackNum(){
        return attackNum;
    }
}
