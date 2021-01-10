package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.processer.AbstractHeroSkillPostProcessor;
import com.jk.game.hearthstone.core.processer.AbstractHeroSkillPreprocessor;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

import java.util.List;

/**
 * 英雄技能执行者
 *
 * @author jk
 */
public class HeroSkillHandler {

    public static void doHeroSkill(Desktop desktop, Hero hero, Organism target) throws IllegalOperationException {
        doPreprocessor(desktop, hero, target);
        //扣费
        desktop.getPlayer(hero.getPlayerType()).costPower(hero.getHeroSkill().getSkillCost(),0);
        //发动效果
        hero.getHeroSkill().execute(desktop,target);
        doPostProcessor(desktop, hero, target);
    }

    private static void doPreprocessor(Desktop desktop, Hero hero, Organism target) throws IllegalOperationException {
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_HERO_SKILL);
        for (Processor processor : processors) {
            ((AbstractHeroSkillPreprocessor)processor).doHeroSkillPreprocessor(desktop, hero, target);
        }
    }

    private static void doPostProcessor(Desktop desktop, Hero hero, Organism target){
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.POST_HERO_SKILL);
        for (Processor processor : processors) {
            ((AbstractHeroSkillPostProcessor)processor).doHeroSkillPostProcessor(desktop, hero, target);
        }
    }
}
