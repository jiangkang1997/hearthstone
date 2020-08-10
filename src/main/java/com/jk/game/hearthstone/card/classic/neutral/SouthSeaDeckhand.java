package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 南海船工
 *
 * @author jk
 * @date 2020/8/9 23:45
 */
public class SouthSeaDeckhand extends Minion{

    private static final String DESC = "如果你装备一把武器，该随从具有冲锋";

    public SouthSeaDeckhand(Desktop desktop){
        super(desktop,1,2,1,"南海船工",DESC, CardType.CARD_TYPE_NEUTRAL);
    }

    @Override
    public boolean isCharge() {
        return getDesktop().getPlayer(getPlayerType()).getArms() != null;
    }
}
