package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;

/**
 * @author jk
 * @date 2021/1/10 16:07
 */
public abstract class AbstractTreatmentPostProcess extends AbstractProcessor {

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
