package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.config.BattleCry;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Stand;
import lombok.NonNull;


/**
 * 叫嚣的中士
 *
 * @author jk
 */
@TargetScope(classScope = Minion.class,stand = Stand.FRIEND)
public class AbusiveSergeant extends Minion implements BattleCry {

    private static final String DESC = "战吼：在本回合中，使一个随从获得+2攻击力";

    public AbusiveSergeant(){
        super(1,1,1,"叫嚣的中士", DESC, CardType.CARD_TYPE_NEUTRAL);
    }

    @Override
    public void effect(Desktop desktop, @NonNull Organism target) {
        final Integer num = 2;
        AbusiveSergeantAura aura = new AbusiveSergeantAura(this,target,num);
        desktop.getAuraManager().register(aura);
    }


    static class AbusiveSergeantAura extends AbstractAttackAura{

        AbusiveSergeantAura(Card owner, Organism target, Integer num){
            auraLife = AuraLife.AURA_LIFE_ONE_TURN;
            isSpecified = true;
            setOwner(owner);
            this.target = target;
            this.num = num;
        }
    }
}
