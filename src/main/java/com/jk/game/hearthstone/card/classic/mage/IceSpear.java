package com.jk.game.hearthstone.card.classic.mage;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

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
            //todo: 伤害操作应该由独立的handler去完成 hurtHandler
            target.setHealth(target.getHealth() - (4 + desktop.getSpellPower(this.getPlayerType())));
        }
        target.setFreeze(true);
    }
}
