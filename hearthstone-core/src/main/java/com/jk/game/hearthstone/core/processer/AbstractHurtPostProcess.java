package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;

/**
 * @author jk
 * @date 2021/1/10 15:57
 */
public abstract class AbstractHurtPostProcess extends AbstractProcessor{

    private static final ProcessorType PROCESS_TYPE = ProcessorType.POST_HURT;

    public AbstractHurtPostProcess(Card owner) {
        super(owner);
    }


    /**
     * 伤害后置处理方法
     * @param desktop
     * @param source
     * @param target
     * @param num
     */
    public abstract void processAfterHurt(Desktop desktop, Card source, Organism target,int num);


    @Override
    public ProcessorType getProcessorType() {
        return PROCESS_TYPE;
    }
}
