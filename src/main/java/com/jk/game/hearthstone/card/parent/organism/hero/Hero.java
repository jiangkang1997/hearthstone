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
     * 护甲
     */
    protected int armor = 0;

    /**
     * 是否可以使用英雄技能
     */
    protected Boolean canSkill = true;

    /**
     * 英雄技能
     */
    protected HeroSkill heroSkill;

    private static final int ATTACK = 0;
    private static final int HEALTH = 30;

    public Hero(Desktop desktop, String name,HeroSkill heroSkill, PlayerType playerType){
        super(desktop,0,ATTACK,HEALTH,name,"", CardType.CARD_TYPE_MAGE);
        this.playerType = playerType;
        this.heroSkill = heroSkill;
        canAttack = true;
        if(heroSkill != null){
            heroSkill.setSkillOwner(this);
        }
    }

    public Hero(Desktop desktop,String name,HeroSkill heroSkill,int armor,PlayerType playerType){
        this(desktop,name,heroSkill,playerType);
        this.armor = armor;
    }

    @Override
    public int getAttack() {
        //自身攻击力加上武器的攻击力
        int attack =  super.getAttack();
        if(desktop.getPlayer(getPlayerType()).getArms() != null){
            attack += desktop.getPlayer(getPlayerType()).getArms().getAttack();
        }
        return attack;
    }

    @Override
    public boolean isCanAttack() {
        return !freeze && canAttack && getAttack()>0;
    }

    @Override
    public boolean isCanAttackHero() {
        return isCanAttack() && canAttackHero;
    }
}
