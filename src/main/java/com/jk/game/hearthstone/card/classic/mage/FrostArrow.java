package com.jk.game.hearthstone.card.classic.mage;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.handler.HurtHandler;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 寒冰箭
 * @author jk
 */
@TargetScope
public class FrostArrow extends NormalMagic {

    private static final String DESC = "对一个角色造成3点伤害，并使其冻结";

    public FrostArrow(Desktop desktop){
        super(desktop, 2, "寒冰箭", DESC, CardType.CARD_TYPE_MAGE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        target.setFreeze(true);
        HurtHandler.doHurt(desktop,this,target,3 + desktop.getSpellPower(this.getPlayerType()));
    }
}
