package com.jk.game.hearthstone.card.parent.organism.hero;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
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
}