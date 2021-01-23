package com.jk.game.hearthstone.card.classic.warror;

import com.jk.game.hearthstone.core.annotation.TargetScope;
import com.jk.game.hearthstone.core.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.handler.HurtHandler;

/**
 * 盾牌猛击
 * @author jk
 * @date 2021/1/23 12:49
 */
@TargetScope(classScope = Minion.class)
public class ShieldSlam extends NormalMagic {
    private static final int COST = 1;
    private static final String NAME = "盾牌猛击";
    private static final String DESC = "每当一个随从受到伤害，便获得+1攻击力";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_WARRIOR;

    public ShieldSlam(Desktop desktop) {
        super(desktop, COST, NAME, DESC, CARD_TYPE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        int attack = desktop.getPlayer(playerType).getHero().getArmor();
        HurtHandler.doHurt(desktop,this,target,attack);
    }
}
