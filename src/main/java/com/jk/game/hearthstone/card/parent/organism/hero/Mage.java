package com.jk.game.hearthstone.card.parent.organism.hero;

import com.jk.game.hearthstone.annotation.TargetScope;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.handler.HurtHandler;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;

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
    static class MageHeroSkill extends HeroSkill{

        public MageHeroSkill(Hero skillOwner){
            super(skillOwner);
        }

        @Override
        public void execute(Desktop desktop, Organism target) {
            HurtHandler.doHurt(desktop,getSkillOwner(),target,1);
        }
    }
}
