package com.jk.game.hearthstone.card.base.warrior;

import com.jk.game.hearthstone.core.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.handler.HurtHandler;

import java.util.Iterator;

/**
 * 旋风斩
 * @author jk
 * @date 2021/1/23 12:55
 */
public class Whirlwind extends NormalMagic {

    private static final int COST = 1;
    private static final String NAME = "旋风斩";
    private static final String DESC = "对所有随从造成一点伤害";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_WARRIOR;

    public Whirlwind(Desktop desktop) {
        super(desktop, COST, NAME, DESC, CARD_TYPE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        Iterator<Minion> mainIterator = desktop.getMainMinions().iterator();
        Iterator<Minion> secondIterator = desktop.getSecondMinions().iterator();
        while (mainIterator.hasNext()){
            HurtHandler.doHurt(desktop,this,mainIterator.next(),1);
        }
        while (secondIterator.hasNext()){
            HurtHandler.doHurt(desktop,this,secondIterator.next(),1);
        }
    }
}
