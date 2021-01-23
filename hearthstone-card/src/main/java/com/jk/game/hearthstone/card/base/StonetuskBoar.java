package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

/**
 * 石牙野猪
 * @author jk
 * @date 2021/1/12 22:31
 */
public class StonetuskBoar extends Minion {

    private static final int COST = 1;
    private static final int ATTACK = 1;
    private static final int HEALTH = 1;
    private static final String NAME = "石牙野猪";
    private static final String DESC = "冲锋";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_BEAST;

    public StonetuskBoar(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
        charge = true;
    }
}
