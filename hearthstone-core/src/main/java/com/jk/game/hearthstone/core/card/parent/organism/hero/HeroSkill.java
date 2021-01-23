package com.jk.game.hearthstone.core.card.parent.organism.hero;

import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.data.Desktop;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author jk
 * @date 2021/1/4 23:21
 */
@Getter
@Setter
public abstract class HeroSkill implements Serializable {

    public HeroSkill(Hero skillOwner){
        this.skillOwner = skillOwner;
    }

    //todo: 被动技能的设计

    /**
     * 技能消耗
     */
    protected int skillCost = 2;

    /**
     * 技能的拥有者
     */
    protected Hero skillOwner;

    /**
     * 使用技能
     * @param desktop
     * @param target
     */
    public abstract void execute(Desktop desktop, Organism target);

    public int getSkillCost(){
        //todo: 光环 buff
        return skillCost;
    }
}
