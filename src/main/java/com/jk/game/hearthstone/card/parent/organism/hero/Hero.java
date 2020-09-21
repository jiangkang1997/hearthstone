package com.jk.game.hearthstone.card.parent.organism.hero;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有英雄的基类
 * @author jk
 */
@Getter
@Setter
public class Hero extends Organism{

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

    /**
     * 副本
     */
    private Hero duplicate;

    private static final int ATTACK = 0;
    private static final int HEALTH = 30;

    public Hero(Desktop desktop, String name, PlayerType playerType){
        super(desktop,0,ATTACK,HEALTH,name,"", CardType.CARD_TYPE_MAGE);
        this.playerType = playerType;
    }

    public Hero(Desktop desktop,String name,int skillCost,int armor,PlayerType playerType){
        this(desktop,name,playerType);
        this.skillCost = skillCost;
        this.armor = armor;
    }


    @Override
    public Hero clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Hero) super.clone();
        }
        return duplicate;
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
