package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.AttackParameters;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * 攻击前置处理器  用于拦截非法的攻击指令
 * @author ：lb
 * @date ：Created in 2020/8/16 3:47
 */
public abstract class AbstractAttackPreProcessor extends AbstractProcessor{

    private final ProcessorType PROCESSOR_TYPE = ProcessorType.PRE_ATTACK;

    public AbstractAttackPreProcessor(Card owner) {
        super(owner);
    }

    /**
     * 攻击前置处理方法
     * @param desktop
     * @param source
     * @param target
     * @throws IllegalOperationException 非法操作
     */
    public abstract void processBeforeHeroAttack(Desktop desktop, Organism source,Organism target) throws IllegalOperationException;

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
