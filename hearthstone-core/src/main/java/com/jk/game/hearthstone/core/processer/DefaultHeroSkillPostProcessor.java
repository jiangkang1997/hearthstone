package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.data.Desktop;

/**
 * @author jk
 * @date 2021/1/12 21:26
 */
public class DefaultHeroSkillPostProcessor extends AbstractHeroSkillPostProcessor {

    public DefaultHeroSkillPostProcessor(Card owner) {
        super(owner);
    }

    @Override
    public void doHeroSkillPostProcessor(Desktop desktop, Hero hero, Organism target) {
        hero.setCanSkill(false);
    }
}
