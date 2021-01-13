package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 石牙野猪
 * @author jk
 * @date 2021/1/12 22:31
 */
public class StonetuskBoar extends Minion {

    private static final String NAME = "石牙野猪";
    private static final String DESC = "冲锋";

    public StonetuskBoar(Desktop desktop) {
        super(desktop, 1, 1, 1, NAME, DESC, CardType.CARD_TYPE_NEUTRAL);
        charge = true;
    }
}
