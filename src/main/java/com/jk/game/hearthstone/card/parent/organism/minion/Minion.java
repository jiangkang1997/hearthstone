package com.jk.game.hearthstone.card.parent.organism.minion;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.core.aura.Aura;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.AuraType;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Stand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.List;

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

    public Minion(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType){
        super(desktop,cost, attack, health, name, desc, cardType);
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

    @Override
    public int getAttack() {
        int attack = super.getAttack();
        //光环计算
        List<Aura> attackAuras = desktop.getAuraManager().getAurasByType(AuraType.AURA_TYPE_ATTACK);
        if(!CollectionUtils.isEmpty(attackAuras)){
            for (Aura attackAura : attackAuras) {
                if(attackAura.getClassScope() == Hero.class){
                    continue;
                }
                Card owner = attackAura.getOwner();
                if(attackAura.getStand() == Stand.ALL){
                    attack += ((AbstractAttackAura) attackAura).getNum();
                }
                else if(attackAura.getStand() == Stand.FRIEND && owner.getPlayerType() == playerType){
                    attack += ((AbstractAttackAura) attackAura).getNum();
                }
                else if(attackAura.getStand() == Stand.FOE && owner.getPlayerType() != playerType){
                    attack += ((AbstractAttackAura) attackAura).getNum();
                }
            }
        }
        return attack;
    }
}
