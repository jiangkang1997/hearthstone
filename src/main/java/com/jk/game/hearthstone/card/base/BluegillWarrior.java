package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 蓝鳃战士
 * @author jk
 * @date 2021/1/10 17:04
 */
public class BluegillWarrior extends Minion {

    private static final String NAME = "蓝鳃战士";
    private static final String DESC = "冲锋";


    public BluegillWarrior(Desktop desktop){
        super(desktop,2,2,1,NAME,DESC, CardType.CARD_TYPE_NEUTRAL);
        charge = true;
    }
}
