package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Race;

/**
 * 小精灵
 *
 * @author jk
 */
public class Wisp extends Minion {

    private static final int COST = 0;
    private static final int ATTACK = 1;
    private static final int HEALTH = 1;
    private static final String NAME = "小精灵";
    private static final String DESC = "";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_MINION;

    public Wisp(Desktop desktop){
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
    }

}
