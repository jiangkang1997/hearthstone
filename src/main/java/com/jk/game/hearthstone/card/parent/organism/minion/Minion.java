package com.jk.game.hearthstone.card.parent.organism.minion;


import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有随从的基类
 *
 * @author jk
 */
@Getter
@Setter
public class Minion extends Organism{

    /**
     * 冲锋
     */
    protected boolean charge = false;
    /**
     * 突袭
     */
    protected boolean raid = false;
    /**
     * 生日
     */
    protected int birthday = -1;

    public Minion(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType){
        super(desktop,cost, attack, health, name, desc, cardType);
    }

    @Override
    public boolean isCanAttack() {
        if(!freeze){
            return birthday == desktop.getHistory().getCurrentTurnNo() ? charge : canAttack;
        }
        return false;
    }

    @Override
    public boolean isCanAttackHero() {
        return birthday == desktop.getHistory().getCurrentTurnNo() ? raid : canAttack;
    }
}
