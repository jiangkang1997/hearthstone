package com.jk.game.hearthstone.card.witch;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

/**
 * 狂暴的狼人
 * @author jk
 * @date 2021/1/23 13:08
 */
public class FuriousWerewolf extends Minion {

    private static final int COST = 3;
    private static final int ATTACK = 3;
    private static final int HEALTH = 3;
    private static final String NAME = "狂暴的狼人";
    private static final String DESC = "突袭";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_WARRIOR;
    private static final Race RACE = Race.RACE_MINION;

    public FuriousWerewolf(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
        raid = true;
    }
}
