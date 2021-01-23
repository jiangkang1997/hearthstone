package com.jk.game.hearthstone.card.base.warrior;

import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.hero.HeroSkill;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;

/**
 * 战士
 * @author jk
 * @date 2021/1/23 12:18
 */
public class Warrior extends Hero {

    private static final String NAME = "战士";

    public Warrior(Desktop desktop, PlayerType playerType) {
        super(desktop,NAME,new WarriorHeroSkill(null),playerType);
    }

    public static class WarriorHeroSkill extends HeroSkill{

        public WarriorHeroSkill(Hero skillOwner) {
            super(skillOwner);
        }

        @Override
        public void execute(Desktop desktop, Organism target) {
            skillOwner.setArmor(skillOwner.getArmor()+2);
        }
    }
}
