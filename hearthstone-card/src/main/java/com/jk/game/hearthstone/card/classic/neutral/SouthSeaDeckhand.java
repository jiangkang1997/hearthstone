package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

/**
 * 南海船工
 *
 * @author jk
 * @date 2020/8/9 23:45
 */
public class SouthSeaDeckhand extends Minion{

    private static final int COST = 1;
    private static final int ATTACK = 2;
    private static final int HEALTH = 1;
    private static final String NAME = "南海船工";
    private static final String DESC = "如果你装备一把武器，该随从具有冲锋";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_PIRATE;

    public SouthSeaDeckhand(Desktop desktop){
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
    }

    @Override
    public boolean isCharge() {
        return getDesktop().getPlayer(getPlayerType()).getArms() != null;
    }
}
