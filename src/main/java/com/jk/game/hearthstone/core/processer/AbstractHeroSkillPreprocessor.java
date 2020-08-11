package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * @author jk
 */
public abstract class AbstractHeroSkillPreprocessor extends AbstractProcessor {

    private static final ProcessorType PROCESSOR_TYPE = ProcessorType.PRE_HERO_SKILL;

    /**
     * 英雄技能前置处理方法
     * @param desktop 桌面环境
     * @param hero 释放技能的英雄
     * @param target 技能目标
     * @throws IllegalOperationException 非法操作异常
     */
    public abstract void doHeroSkillPreprocessor(Desktop desktop, Hero hero, Organism target) throws IllegalOperationException;

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
