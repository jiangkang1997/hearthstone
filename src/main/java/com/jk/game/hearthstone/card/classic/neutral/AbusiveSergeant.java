package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.annotation.InitializedProcessor;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.config.BattleCry;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;


/**
 * 叫嚣的中士
 *
 * @author jk
 */
public class AbusiveSergeant extends Minion {

    private static final String DESC = "战吼：在本回合中，使一个随从获得+2攻击力";

    public AbusiveSergeant(){

        super(1,1,1,"叫嚣的中士", DESC, CardType.CARD_TYPE_NEUTRAL);
    }

    @InitializedProcessor
    static class AbusiveSergeantBattleCry implements BattleCry{

        @Override
        public void effect(Desktop desktop, Organism target) {

        }
    }
}
