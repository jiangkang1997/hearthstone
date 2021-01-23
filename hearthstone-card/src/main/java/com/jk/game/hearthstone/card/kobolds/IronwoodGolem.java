package com.jk.game.hearthstone.card.kobolds;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Race;

/**
 * 铁木魔像
 * @author jk
 * @date 2021/1/23 12:09
 */
public class IronwoodGolem extends Minion {

    private static final int COST = 4;
    private static final int ATTACK = 3;
    private static final int HEALTH = 6;
    private static final String NAME = "铁木魔像";
    private static final String DESC = "嘲讽，除非你的护甲大于等于3点，否则无法攻击";
    private static final CardType CARD_TYPE = CardType.CARD_TYPE_DRUID;
    private static final Race RACE = Race.RACE_MINION;

    public IronwoodGolem(Desktop desktop) {
        super(desktop,COST,ATTACK,HEALTH,NAME, DESC, CARD_TYPE,RACE);
        ridicule = true;
    }

    @Override
    public boolean isCanAttack() {
        return super.isCanAttack() && desktop.getPlayer(playerType).getHero().getArmor()>=3;
    }
}
