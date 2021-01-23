package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;

/**
 * @author jk
 * @date 2021/1/13 19:28
 */
public abstract class AbstractEndRoundPostProcess extends AbstractProcessor {

    private final ProcessorType PROCESSOR_TYPE = ProcessorType.POST_END_ROUND;

    public AbstractEndRoundPostProcess(Card owner) {
        super(owner);
    }

    /**
     * 回合结束后置处理方法
     * @param desktop
     * @param playerType
     */
    public abstract void processAfterEndRound(Desktop desktop, PlayerType playerType);

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
