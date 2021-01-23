package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.arms.Arms;
import com.jk.game.hearthstone.core.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.config.Conditional;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;

import static com.jk.game.hearthstone.core.enumeration.Dictionary.MAX_TURN;

/**
 * 致命药膏
 * @author jk
 * @date 2021/1/10 17:19
 */
public class DeathlyPoison extends NormalMagic implements Conditional {

    private static final String NAME = "致命药膏";
    private static final String DESC = "使你的武器获得+2攻击力";

    public DeathlyPoison(Desktop desktop) {
        super(desktop, 1, NAME, DESC, CardType.CARD_TYPE_ROGUE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        Arms arms = desktop.getPlayer(this.getPlayerType()).getArms();
        if(arms != null){
            arms.registerBuff(new DeathlyPoisonBuff(this));
        }
    }

    @Override
    public boolean condition(Desktop desktop) {
        Arms arms = desktop.getPlayer(this.getPlayerType()).getArms();
        return arms != null;
    }

    static class DeathlyPoisonBuff extends AbstractAttackBuff{

        private static final int ATTACK_NUM = 2;
        private static final int LIFE = MAX_TURN;

        DeathlyPoisonBuff(Card owner) {
            super(owner,LIFE,ATTACK_NUM);
        }
    }
}
