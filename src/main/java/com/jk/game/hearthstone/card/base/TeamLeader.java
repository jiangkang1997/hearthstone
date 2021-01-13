package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.annotation.InitializedAura;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Stand;

/**
 * 团队领袖
 * @author jk
 * @date 2021/1/13 20:18
 */
public class TeamLeader extends Minion {

    private static final String NAME = "团队领袖";
    private static final String DESC = "你的其他随从获得+1攻击力";

    public TeamLeader(Desktop desktop) {
        super(desktop, 3, 2, 2, NAME, DESC, CardType.CARD_TYPE_NEUTRAL);
    }


    @InitializedAura
    public static class TeamLeaderAura extends AbstractAttackAura{

        private static final  Class<? extends Organism> CLASS_SCOPE = Minion.class;
        private static final  Stand STAND = Stand.FRIEND;
        private static final  AuraLife AURA_LIFE = AuraLife.AURA_LIFE_DEPEND;
        private static final  Integer NUM = 1;

        public TeamLeaderAura(Card owner) {
            super(owner, CLASS_SCOPE, STAND, AURA_LIFE, NUM);
        }
    }
}
