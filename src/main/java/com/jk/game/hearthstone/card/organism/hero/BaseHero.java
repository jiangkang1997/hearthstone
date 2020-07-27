package com.jk.game.hearthstone.card.organism.hero;

import com.jk.game.hearthstone.card.arms.BaseArms;
import com.jk.game.hearthstone.card.organism.BaseOrganism;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有英雄的基类
 * @author jk
 */
@Getter
@Setter
public abstract class BaseHero extends BaseOrganism implements Cloneable {

    private Integer skillCost = 2;
    private BaseArms arms = null;
    private Integer armor = 0;

    private Boolean canSkill = true;


    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result =  super.clone();
        if(this.arms!=null){
            ((BaseHero)result).arms = (BaseArms) this.arms.clone();
        }
        return result;
    }
}
