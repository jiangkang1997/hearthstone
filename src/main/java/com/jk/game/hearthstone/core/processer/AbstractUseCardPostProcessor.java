package com.jk.game.hearthstone.core.processer;


import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;

/**
 * The class that implements this interface is considered a PlayPostProcess
 * Any play operation will trigger the execution of the processAfterPlay method.
 *
 * @author jk
 */
public abstract class AbstractUseCardPostProcessor extends AbstractProcessor {

    private final ProcessorType PROCESSOR_TYPE = ProcessorType.POST_USE_CARD;

    public AbstractUseCardPostProcessor(Card owner) {
        super(owner);
    }

    /**
     * 在出牌操作后触发
     *
     * @param desktop 桌面环境
     * @param card 使用的卡牌
     */
    public abstract void processAfterPlay(Desktop desktop, Card card);

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
