package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.core.card.parent.arms.Arms;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;

/**
 * 邪恶短刀
 * @author jk
 * @date 2021/1/10 17:25
 */
public class EvilDagger extends Arms {

    private static final String NAME = "邪恶短刀";

    public EvilDagger(Desktop desktop) {
        super(desktop, 1, 1, 2, NAME, "", CardType.CARD_TYPE_ROGUE);
    }
}
