package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.core.annotation.InitializedAura;
import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.AuraLife;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

/**
 * 团队领袖
 * @author jk
 * @date 2021/1/13 20:18
 */
public class TeamLeader extends Minion {

    private static final int COST = 3;
    private static final int ATTACK = 2;
    private static final int HEALTH = 2;
    private static final String NAME = "团队领袖";
    private static final String DESC = "你的其他随从获得+1攻击力";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_MINION;

    public TeamLeader(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
    }


    @InitializedAura
    public static class TeamLeaderAura extends AbstractAttackAura{

        private static final  AuraLife AURA_LIFE = AuraLife.AURA_LIFE_DEPEND;
        private static final  Integer NUM = 1;

        public TeamLeaderAura(Card owner) {
            super(owner, AURA_LIFE, NUM);
        }

        @Override
        public boolean judge(Card card) {
            Desktop desktop = card.getDesktop();
            return card instanceof Minion &&
                    desktop.getMinions(card.getPlayerType()).getList().contains(card) &&
                    card.getPlayerType() == getOwner().getPlayerType() &&
                    card != getOwner();
        }
    }
}
