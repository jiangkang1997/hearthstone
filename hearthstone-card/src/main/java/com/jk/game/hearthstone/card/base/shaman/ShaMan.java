package com.jk.game.hearthstone.card.base.shaman;

import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.hero.HeroSkill;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;

/**
 * 萨满祭司
 * @author jk
 * @date 2021/1/13 19:31
 */
public class ShaMan extends Hero {

    private static final String NAME = "萨满祭司";

    public ShaMan(Desktop desktop,PlayerType playerType) {
        super(desktop, NAME, new ShaManSkill(null), playerType);
    }

    static class ShaManSkill extends HeroSkill {

        public ShaManSkill(Hero skillOwner) {
            super(skillOwner);
        }

        @Override
        public void execute(Desktop desktop, Organism target) {

        }
    }
}
