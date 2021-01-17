package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.config.BattleCry;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Race;
import com.jk.game.hearthstone.enumeration.Stand;

import static com.jk.game.hearthstone.enumeration.Dictionary.MAX_TURN;


/**
 * 叫嚣的中士
 *
 * @author jk
 */
@TargetScope(classScope = Minion.class,stand = Stand.FRIEND)
public class AbusiveSergeant extends Minion implements BattleCry {

    private static final int COST = 1;
    private static final int ATTACK = 1;
    private static final int HEALTH = 1;
    private static final String NAME = "叫嚣的中士";
    private static final String DESC = "战吼：在本回合中，使一个随从获得+2攻击力";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_MINION;

    public AbusiveSergeant(Desktop desktop){
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        if(target != null){
            AbusiveSergeantBuff buff = new AbusiveSergeantBuff(this);
            target.registerBuff(buff);
        }
    }


    static class AbusiveSergeantBuff extends AbstractAttackBuff {

        private static final int ATTACK_NUM = 2;
        private static final int LIFE = MAX_TURN;

        AbusiveSergeantBuff(Card owner){
            super(owner,LIFE,ATTACK_NUM);
        }
    }
}
