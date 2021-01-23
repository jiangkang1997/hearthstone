package com.jk.game.hearthstone.card.classic.warror;

import com.jk.game.hearthstone.core.annotation.InitializedProcessor;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;
import com.jk.game.hearthstone.core.processer.AbstractHurtPostProcess;

import static com.jk.game.hearthstone.core.enumeration.Dictionary.MAX_TURN;

/**
 * 暴乱狂战士
 * @author jk
 * @date 2021/1/23 12:25
 */
public class RiotBerserker extends Minion {

    private static final int COST = 3;
    private static final int ATTACK = 2;
    private static final int HEALTH = 4;
    private static final String NAME = "暴乱狂战士";
    private static final String DESC = "每当一个随从受到伤害，便获得+1攻击力";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_WARRIOR;
    private static final Race RACE = Race.RACE_MINION;

    public RiotBerserker(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
    }

    @InitializedProcessor
    public static class RiotBerserkerProcess extends AbstractHurtPostProcess{

        public RiotBerserkerProcess(Card owner) {
            super(owner);
        }

        @Override
        public void processAfterHurt(Desktop desktop, Card source, Organism target, int num) {
            if(target instanceof Minion){
                ((Minion)getOwner()).registerBuff(new RiotBerserkerBuff(getOwner()));
            }
        }
    }


    public static class RiotBerserkerBuff extends AbstractAttackBuff{

        private static final int ATTACK_NUM = 1;
        private static final int LIFE = MAX_TURN;

        public RiotBerserkerBuff(Card owner) {
            super(owner, LIFE, ATTACK_NUM);
        }
    }
}
