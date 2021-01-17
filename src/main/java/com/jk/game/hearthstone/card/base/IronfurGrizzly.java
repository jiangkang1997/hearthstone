package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Race;

/**
 * 铁鬓灰熊
 * @author jk
 * @date 2021/1/17 22:36
 */
public class IronfurGrizzly extends Minion {

    private static final int COST = 3;
    private static final int ATTACK = 3;
    private static final int HEALTH = 3;
    private static final String NAME = "铁鬓灰熊";
    private static final String DESC = "嘲讽";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_BEAST;

    public IronfurGrizzly(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
        ridicule = true;
    }
}
