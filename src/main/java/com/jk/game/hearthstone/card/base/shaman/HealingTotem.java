package com.jk.game.hearthstone.card.base.shaman;

import com.jk.game.hearthstone.annotation.InitializedProcessor;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.handler.TreatmentHandler;
import com.jk.game.hearthstone.core.processer.AbstractEndRoundPostProcess;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 治疗图腾
 * @author jk
 * @date 2021/1/13 19:34
 */
public class HealingTotem extends Minion {

    private static final String NAME = "治疗图腾";
    private static final String DESC = "回合结束时，为你的所有随从恢复+1生命值";

    public HealingTotem(Desktop desktop) {
        super(desktop, 1, 0, 2, NAME, DESC, CardType.CARD_TYPE_SHAMAN);
    }


    @InitializedProcessor
    public static class HealingTotemEndRoundPostProcess extends AbstractEndRoundPostProcess{

        public HealingTotemEndRoundPostProcess(Card owner) {
            super(owner);
        }

        @Override
        public void processAfterEndRound(Desktop desktop, PlayerType playerType) {
            List<Minion> minions = desktop.getMinions(getOwner().getPlayerType()).getList();
            if(!CollectionUtils.isEmpty(minions)){
                for (Minion minion : desktop.getMinions(getOwner().getPlayerType()).getList()) {
                    TreatmentHandler.doTreatment(desktop,getOwner(),minion,1);
                }
            }
        }
    }
}
