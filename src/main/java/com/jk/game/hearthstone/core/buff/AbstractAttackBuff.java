package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.enumeration.BuffType;

/**
 *
 *
 * @author jk
 */
public abstract class AbstractAttackBuff extends AbstractBuff {

    private static final BuffType BUFF_TYPE = BuffType.BUFF_TYPE_ATTACK;

    @Override
    public BuffType getBuffType() {
        return BUFF_TYPE;
    }

    /**
     * 获取buff的攻击力数值
     * @return
     */
    public abstract int getAttackNum();

}
