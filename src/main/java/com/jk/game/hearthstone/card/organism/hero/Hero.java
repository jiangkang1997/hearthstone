package com.jk.game.hearthstone.card.organism.hero;

import com.jk.game.hearthstone.card.arms.Arms;
import com.jk.game.hearthstone.card.organism.Organism;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有英雄的基类
 * @author jk
 */
@Getter
@Setter
public class Hero extends Organism implements Cloneable {

    private Integer skillCost = 2;
    private Arms arms = null;
    private Integer armor = 0;

    private Boolean canSkill = true;


    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result =  super.clone();
        if(this.arms!=null){
            ((Hero)result).arms = (Arms) this.arms.clone();
        }
        return result;
    }
}
