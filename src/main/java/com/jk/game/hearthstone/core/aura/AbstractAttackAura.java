package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.enumeration.AuraType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础的攻击力型光环，改变攻击力数值的buff
 *
 * @Author jk
 * @Date 2020/8/2 23:09
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class AbstractAttackAura extends AbstractAura {

    private static final AuraType AURA_TYPE = AuraType.AURA_TYPE_ATTACK;

    /**
     * 被施加光环的目标，只有是指定目标型的光环时，才被使用
     */
    protected Organism target;

    /**
     * 目标被修改的攻击力数值
     */
    protected Integer num;
}
