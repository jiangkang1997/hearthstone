package com.jk.game.hearthstone.card.base.shaman;

import com.jk.game.hearthstone.core.annotation.TargetScope;
import com.jk.game.hearthstone.core.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;

/**
 * 风怒
 * @author jk
 * @date 2021/1/13 20:01
 */
@TargetScope(classScope = Minion.class)
public class Windfury extends NormalMagic {

    private static final String NAME = "风怒";
    private static final String DESC = "使一个随从获得风怒";

    public Windfury(Desktop desktop) {
        super(desktop, 2, NAME, DESC, CardType.CARD_TYPE_SHAMAN);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        if(target != null){
            target.setWindfury(true);
        }
    }
}
