package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.processer.AbstractHeroSkillPostProcessor;
import com.jk.game.hearthstone.core.processer.AbstractHeroSkillPreprocessor;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;
import com.jk.game.hearthstone.core.exception.IllegalOperationException;

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
        //死亡结算
        DeathHandler.doDeathHandler(desktop);
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
