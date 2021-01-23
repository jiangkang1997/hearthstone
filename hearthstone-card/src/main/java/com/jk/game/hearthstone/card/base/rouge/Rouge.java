package com.jk.game.hearthstone.card.base.rouge;

import com.jk.game.hearthstone.card.base.EvilDagger;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.hero.HeroSkill;
import com.jk.game.hearthstone.core.handler.JoinHandler;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;
import com.jk.game.hearthstone.core.exception.InvalidOperationException;

/**
 * 潜行者
 * @author jk
 * @date 2021/1/4 23:30
 */
public class Rouge extends Hero {

    private static final String NAME = "潜行者";

    public Rouge(Desktop desktop, PlayerType playerType) {
        super(desktop, NAME,new RougeHeroSkill(null), playerType);
    }

    static class RougeHeroSkill extends HeroSkill {

        public RougeHeroSkill(Hero skillOwner){
            super(skillOwner);
        }

        @Override
        public void execute(Desktop desktop, Organism target) {
            try {
                EvilDagger evilDagger = new EvilDagger(desktop);
                evilDagger.setPlayerType(getSkillOwner().getPlayerType());
                JoinHandler.join(desktop,evilDagger,null);
            }catch (IllegalAccessException | InstantiationException | InvalidOperationException ignored) {}
        }
    }
}
