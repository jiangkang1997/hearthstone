package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * @author ：lb
 * @date ：Created in 2020/8/16 3:51
 */
public abstract class AbstractMinionAttackPostProcessor extends AbstractProcessor{
    private final ProcessorType PROCESSOR_TYPE = ProcessorType.POST_MINIONATTACK_SKILL;

    /**
     * @Description:
     * @Param: [desktop, card, target]
     * @return: void
     * @Author: lb
     * @Date: 2020/8/16
     */
    public abstract void processAfterMinionAttack(Desktop desktop, Card card, Organism target) throws IllegalOperationException;

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
