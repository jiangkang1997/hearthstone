package com.jk.game.hearthstone.card.classic.neutral;

import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.Race;

/**
 * 持盾卫士
 * @author jk
 * @date 2021/1/17 22:32
 */
public class ShieldGuard extends Minion {

    private static final int COST = 1;
    private static final int ATTACK = 0;
    private static final int HEALTH = 4;
    private static final String NAME = "持盾卫士";
    private static final String DESC = "嘲讽";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_NEUTRAL;
    private static final Race RACE = Race.RACE_MINION;

    public ShieldGuard(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
        ridicule = true;
    }
}
