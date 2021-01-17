package com.jk.game.hearthstone.card.base.shaman;

import com.jk.game.hearthstone.annotation.InitializedAura;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.common.MinionCollection;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Race;

/**
 * 火舌图腾
 * @author jk
 * @date 2021/1/17 22:11
 */
public class FlametongueTotem extends Minion {

    private static final int COST = 2;
    private static final int ATTACK = 0;
    private static final int HEALTH = 3;
    private static final String NAME = "火舌图腾";
    private static final String DESC = "相邻的随从获得+2攻击力";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_SHAMAN;
    private static final Race RACE = Race.RACE_TOTEM;

    public FlametongueTotem(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
    }


    @InitializedAura
    public static class FlametongueTotemAura extends AbstractAttackAura{

        private static final  AuraLife AURA_LIFE = AuraLife.AURA_LIFE_DEPEND;
        private static final int NUM = 2;

        public FlametongueTotemAura(Card owner) {
            super(owner, AURA_LIFE,NUM);
        }

        @Override
        public boolean judge(Card card) {
            if(card instanceof Minion && card.getPlayerType() == getOwner().getPlayerType()){
                MinionCollection minions = card.getDesktop().getMinions(card.getPlayerType());
                int ownerSeat = minions.getIndex(getOwner());
                int cardSeat = minions.getIndex(card);
                return ownerSeat >= 0 && cardSeat >= 0 && Math.abs(ownerSeat - cardSeat) == 1;
            }
            return false;
        }
    }
}
