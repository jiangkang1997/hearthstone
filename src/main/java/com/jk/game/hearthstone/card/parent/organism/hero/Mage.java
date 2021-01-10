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
@TargetScope
public class Mage extends Hero {

    private static final String NAME = "法师";

    public Mage(Desktop desktop, PlayerType playerType) {
        super(desktop,NAME,playerType);
        heroSkill = new MageHeroSkill(this);
    }

    @TargetScope
    static class MageHeroSkill extends HeroSkill{

        public MageHeroSkill(Hero skillOwner){
            this.skillOwner = skillOwner;
        }

        @Override
        public void execute(Desktop desktop, Organism target) {
            HurtHandler.doHurt(desktop,getSkillOwner(),target,1);
        }
    }
}
