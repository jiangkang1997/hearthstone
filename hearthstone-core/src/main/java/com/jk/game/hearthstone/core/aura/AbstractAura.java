package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.enumeration.AuraLife;

/**
 * @Author jk
 * @Date 2020/8/2 23:12
 */
public abstract class AbstractAura implements Aura {

    public AbstractAura(Card owner,AuraLife auraLife){
        this.owner = owner;
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
     * 光环的持续时间
     */
    private AuraLife auraLife;


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
}
