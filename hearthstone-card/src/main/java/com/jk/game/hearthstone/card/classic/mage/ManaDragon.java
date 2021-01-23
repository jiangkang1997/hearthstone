package com.jk.game.hearthstone.card.classic.mage;

import com.jk.game.hearthstone.core.annotation.InitializedProcessor;
import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.magic.Magic;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.processer.AbstractUseCardPostProcessor;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

import static com.jk.game.hearthstone.core.enumeration.Dictionary.MAX_TURN;

/**
 * 法力浮龙
 * @author jk
 */
public class ManaDragon extends Minion {

    private static final int COST = 2;
    private static final int ATTACK = 1;
    private static final int HEALTH = 3;
    private static final String NAME = "法力浮龙";
    private static final String DESC = "每当你释放一个法术，获得+1攻击力";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_MAGE;
    private static final Race RACE = Race.RACE_MINION;


    public ManaDragon(Desktop desktop){
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
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
