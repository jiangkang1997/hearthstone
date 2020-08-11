package com.jk.game.hearthstone.card.organism.hero;

import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有英雄的基类
 * @author jk
 */
@Getter
@Setter
public class Hero extends Organism implements Cloneable {

    /**
     * 英雄技能耗费
     */
    protected Integer skillCost = 2;

    /**
     * 护甲
     */
    protected Integer armor = 0;

    /**
     * 是否可以使用英雄技能
     */
    protected Boolean canSkill = true;


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int getAttack() {
        //自身攻击力加上武器的攻击力
        int attack =  super.getAttack();
        int armsAttack = desktop.getPlayer(getPlayerType()).getArms().getAttack();
        return attack + armsAttack;
    }


    public void skill(Desktop desktop,Organism target){}
}
