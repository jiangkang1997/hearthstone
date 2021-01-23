package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;

/**
 * @author jk
 * @date 2021/1/10 16:07
 */
public abstract class AbstractTreatmentPostProcess extends AbstractProcessor {

    public AbstractTreatmentPostProcess(Card owner) {
        super(owner);
    }

    /**
     * 治疗后置处理方法
     * @param desktop
     * @param source
     * @param target
     * @param num
     */
    public abstract void processAfterTreatment(Desktop desktop, Card source, Organism target,int num);

    @Override
    public ProcessorType getProcessorType() {
        return ProcessorType.POST_TREAT;
    }
}
