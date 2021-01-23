package com.jk.game.hearthstone.core.buff;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.enumeration.BuffType;

/**
 *
 *
 * @author jk
 */
public abstract class AbstractAttackBuff extends AbstractBuff {

    private static final BuffType BUFF_TYPE = BuffType.BUFF_TYPE_ATTACK;

    private final Integer ATTACK_NUM;

    public AbstractAttackBuff(Card owner, int life,int attackNum ) {
        super(owner, life);
        ATTACK_NUM = attackNum;
    }

    @Override
    public BuffType getBuffType() {
        return BUFF_TYPE;
    }

    /**
     * 获取buff的攻击力数值
     * @return
     */
    public int getAttackNum(){
        return ATTACK_NUM;
    }

}
