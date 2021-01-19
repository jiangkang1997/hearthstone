package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.AuraType;

/**
 * 基础的攻击力型光环，改变攻击力数值的buff
 *
 * @Author jk
 * @Date 2020/8/2 23:09
 */
public abstract class AbstractAttackAura extends AbstractAura {

    private static final AuraType AURA_TYPE = AuraType.AURA_TYPE_ATTACK;

    /**
     * 目标被修改的攻击力数值
     */
    private Integer num;

    public AbstractAttackAura(Card owner, AuraLife auraLife,int num) {
        super(owner, auraLife);
        this.num = num;
    }

    @Override
    public  AuraType getAuraType() {
        return AURA_TYPE;
    }

    public Integer getNum() {
        return num;
    }
}
