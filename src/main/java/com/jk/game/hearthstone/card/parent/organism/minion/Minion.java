package com.jk.game.hearthstone.card.parent.organism.minion;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Race;
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
     * 种族
     */
    protected Race race;
    /**
     * 冲锋
     */
    protected boolean charge = false;
    /**
     * 突袭
     */
    protected boolean raid = false;
    /**
     * 吸血
     */
    protected boolean bloodSucking = false;
    /**
     * 圣盾
     */
    protected boolean holyShield = false;
    /**
     * 剧毒
     */
    protected boolean highlyToxic = false;
    /**
     * 生日
     */
    protected int birthday = -1;

    public Minion(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType,Race race){
        super(desktop,cost, attack, health, name, desc, cardType);
        this.race = race;
    }

    @Override
    public boolean isCanAttack() {
        if(!freeze && getAttack()>0){
            return canAttack ||
                    (birthday == desktop.getHistory().getCurrentTurnNo()) && (raid || charge) && (attackTime<1) ||
                    (birthday == desktop.getHistory().getCurrentTurnNo()) && (raid || charge) && (attackTime<2) && windfury;
        }
        return false;
    }

    @Override
    public boolean isCanAttackHero() {
        if(!freeze && getAttack()>0){
            return (canAttack && canAttackHero) ||
                    (birthday == desktop.getHistory().getCurrentTurnNo() && charge && canAttackHero && attackTime<1) ||
                    (birthday == desktop.getHistory().getCurrentTurnNo() && charge && canAttackHero && windfury && attackTime<2);
        }
        return false;
    }
}
