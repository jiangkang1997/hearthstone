package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.AuraType;
import com.jk.game.hearthstone.enumeration.Stand;

/**
 * @Author jk
 * @Date 2020/8/2 23:12
 */
public abstract class AbstractAura implements Aura {

    private static final AuraType AURA_TYPE = AuraType.AURA_TYPE_ABSTRACT;

    /**
     * 光环的发起者
     */
    private Card owner = null;

    /**
     * 光环存在的回合数
     */
    private Integer age = 1;

    /**
     *  光环作用的目标类型（随从/英雄/所有）
     */
    protected Class<? extends Organism> classScope;

    /**
     * 光环的持续时间
     */
    protected AuraLife auraLife;

    /**
     *  光环作用的立场（友方/敌方/全部）
     */
    protected Stand stand;

    /**
     * 是否是指定类目标类型的光环
     */
    protected Boolean isSpecified;

    @Override
    public AuraType getAuraType() {
        return AURA_TYPE;
    }

    @Override
    public Card getOwner() {
        return owner;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void countAge() {
        age ++ ;
    }

    @Override
    public AuraLife getAuraLife() {
        return auraLife;
    }

    @Override
    public Class<? extends Organism> getClassScope() {
        return classScope;
    }

    @Override
    public Stand getStand() {
        return stand;
    }

    @Override
    public void setOwner(Card owner) {
        this.owner = owner;
    }
}
