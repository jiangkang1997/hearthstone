package com.jk.game.hearthstone.card.classic.mage;

import com.jk.game.hearthstone.core.annotation.TargetScope;
import com.jk.game.hearthstone.core.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.handler.HurtHandler;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;

/**
 * 冰枪术
 * @author jk
 */
@TargetScope
public class IceSpear extends NormalMagic {

    private static final String DESC = "冻结一个角色，如果该角色已冻结，则对其造成四点伤害";

    public IceSpear(Desktop desktop) {
        super(desktop, 1, "冰枪术", DESC, CardType.CARD_TYPE_MAGE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        if(target.isFreeze()){
            HurtHandler.doHurt(desktop,this,target,4 + desktop.getSpellPower(this.getPlayerType()));
        }
        target.setFreeze(true);
    }
}
