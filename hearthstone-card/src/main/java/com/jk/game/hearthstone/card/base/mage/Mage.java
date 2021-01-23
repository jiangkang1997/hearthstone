package com.jk.game.hearthstone.card.base.mage;

import com.jk.game.hearthstone.core.annotation.TargetScope;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.hero.HeroSkill;
import com.jk.game.hearthstone.core.handler.HurtHandler;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;

/**
 * 法师
 *
 * @author jk
 * @date 2020/8/12 21:45
 */
public class Mage extends Hero {

    private static final String NAME = "法师";

    public Mage(Desktop desktop, PlayerType playerType) {
        super(desktop,NAME,new MageHeroSkill(null),playerType);
    }

    @TargetScope
    static class MageHeroSkill extends HeroSkill {

        public MageHeroSkill(Hero skillOwner){
            super(skillOwner);
        }

        @Override
        public void execute(Desktop desktop, Organism target) {
            HurtHandler.doHurt(desktop,getSkillOwner(),target,1);
        }
    }
}
