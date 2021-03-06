package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

/**
 * 狼骑兵
 * @author jk
 * @date 2021/1/17 22:41
 */
public class Wolfrider extends Minion {

    private static final int COST = 3;
    private static final int ATTACK = 3;
    private static final int HEALTH = 1;
    private static final String NAME = "狼骑兵";
    private static final String DESC = "冲锋";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_MINION;

    public Wolfrider(Desktop desktop){
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
        charge = true;
    }
}
