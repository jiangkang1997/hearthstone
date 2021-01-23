package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;

/**
 * @author jk
 */
public abstract class AbstractHeroSkillPostProcessor extends AbstractProcessor {

    private static final ProcessorType PROCESSOR_TYPE = ProcessorType.POST_HERO_SKILL;

    public AbstractHeroSkillPostProcessor(Card owner) {
        super(owner);
    }

    /**
     * 英雄技能后置处理方法
     * @param desktop 桌面环境
     * @param hero 释放技能的英雄
     * @param target 技能目标
     */
    public abstract void doHeroSkillPostProcessor(Desktop desktop, Hero hero, Organism target);

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
