package com.jk.game.hearthstone.core.processer;

/**
 * @author ：lb
 * @date ：Created in 2020/8/16 3:32
 */

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.data.AttackParameters;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

public abstract class AbstractHeroAttackPreProcessor extends AbstractProcessor {
    private final ProcessorType PROCESSOR_TYPE = ProcessorType.PRE_HEROATTACK_SKILL;

    public AbstractHeroAttackPreProcessor(Card owner) {
        super(owner);
    }

    /**
    * @Description: 
    * @Param: [desktop, attackParameters]
    * @return: void
    * @Author: lb
    * @Date: 2020/8/16
    */
    public abstract void processBeforeHeroAttack(Desktop desktop, AttackParameters attackParameters) throws IllegalOperationException;

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
