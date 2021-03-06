package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;
import com.jk.game.hearthstone.core.exception.IllegalOperationException;

/**
 * @author jk
 */
public abstract class AbstractHeroSkillPreprocessor extends AbstractProcessor {

    private static final ProcessorType PROCESSOR_TYPE = ProcessorType.PRE_HERO_SKILL;

    public AbstractHeroSkillPreprocessor(Card owner) {
        super(owner);
    }

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
