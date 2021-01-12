package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.config.Combo;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

import static com.jk.game.hearthstone.enumeration.Dictionary.MAX_TURN;

/**
 * 冷血
 * @author jk
 * @date 2021/1/10 17:07
 */
public class ColdBlooded extends NormalMagic implements Combo {

    private static final String NAME = "冷血";
    private static final String DESC = "使一个随冲获得+2攻击力，连击：+4攻击力";

    public ColdBlooded(Desktop desktop) {
        super(desktop, 2, NAME, DESC, CardType.CARD_TYPE_ROGUE);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        target.registerBuff(new ColdBloodedBuff(this));
    }

    @Override
    public void combo(Desktop desktop, Organism target) {
        target.registerBuff(new ColdBloodedComboBuff(this));
    }


    static class ColdBloodedBuff extends AbstractAttackBuff{

        private static final int ATTACK_NUM = 2;
        private static final int LIFE = MAX_TURN;

        ColdBloodedBuff(Card owner){
            super(owner,LIFE,ATTACK_NUM);
        }
    }

    static class ColdBloodedComboBuff extends AbstractAttackBuff{

        private static final int ATTACK_NUM = 4;
        private static final int LIFE = MAX_TURN;

        ColdBloodedComboBuff(Card owner){
            super(owner,LIFE,ATTACK_NUM);
        }
    }
}
