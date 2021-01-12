package com.jk.game.hearthstone.card.classic.mage;

import com.jk.game.hearthstone.annotation.InitializedProcessor;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.magic.Magic;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.processer.AbstractUseCardPostProcessor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

import static com.jk.game.hearthstone.enumeration.Dictionary.MAX_TURN;

/**
 * 法力浮龙
 * @author jk
 */
public class ManaDragon extends Minion {

    private static final String DESC = "每当你释放一个法术，获得+1攻击力";

    public ManaDragon(Desktop desktop){
        super(desktop,1,1,3,"法力浮龙",DESC, CardType.CARD_TYPE_MAGE);
    }


    @InitializedProcessor
    public static class ManaDragonProcess extends AbstractUseCardPostProcessor{

        public ManaDragonProcess(Card owner) {
            super(owner);
        }

        @Override
        public void processAfterPlay(Desktop desktop, Card card){
            if(card instanceof Magic){
                ManaDragonAttackBuff manaDragonAttackBuff = new ManaDragonAttackBuff(getOwner());
                ((Minion)getOwner()).registerBuff(manaDragonAttackBuff);
            }
        }

        static class ManaDragonAttackBuff extends AbstractAttackBuff{

            private static final int ATTACK_NUM = 1;
            private static final int LIFE = MAX_TURN;

            ManaDragonAttackBuff(Card owner){
                super(owner,LIFE,ATTACK_NUM);
            }
        }
    }
}
