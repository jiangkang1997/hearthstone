package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.AuraType;
import com.jk.game.hearthstone.enumeration.Stand;

/**
 * @Author jk
 * @Date 2020/8/2 23:12
 */
public abstract class AbstractAura implements Aura {

    public AbstractAura(Card owner,Class<? extends Organism> classScope,Stand stand,AuraLife auraLife){
        this.owner = owner;
        this.classScope = classScope;
        this.stand = stand;
        this.auraLife = auraLife;
    }

    /**
     * 光环的发起者
     */
    private Card owner;

    /**
     * 光环存在的回合数
     */
    private Integer age = 0;

    /**
     *  光环作用的目标类型（随从/英雄/所有）
     */
    private Class<? extends Organism> classScope;

    /**
     * 光环的持续时间
     */
    private AuraLife auraLife;

    /**
     *  光环作用的立场（友方/敌方/全部）
     */
    private Stand stand;


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
}
