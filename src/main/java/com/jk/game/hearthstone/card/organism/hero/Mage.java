package com.jk.game.hearthstone.card.organism.hero;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;

/**
 * 法师
 *
 * @author jk
 * @date 2020/8/12 21:45
 */
@TargetScope
public class Mage extends Hero {

    private static final String NAME = "法师";


    public Mage(Desktop desktop, PlayerType playerType) {
        super(desktop,NAME,playerType);
    }

    @Override
    public void skill(Desktop desktop, Organism target) {
        //todo 对目标造成一点伤害，受到部分buff和光环影响
    }
}
