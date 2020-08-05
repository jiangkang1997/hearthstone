package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * 使用卡牌操作的前置处理器
 * 任何的出牌操作都会触发processBeforePlay方法
 *
 * @author jk
 */
public abstract class AbstractUseCardPreprocessor extends AbstractProcessor {

    private final ProcessorType PROCESSOR_TYPE = ProcessorType.PRE_USE_CARD;


    /**
     * 在出牌前被触发
     * 主要用于检查出牌操作的合法性
     *
     * @param desktop 游戏桌面环境
     * @param card 使用的卡牌
     * @param target 使用卡牌时指向的目标
     * @throws IllegalOperationException 非法的出牌操作
     */
    public abstract void processBeforePlay(Desktop desktop, Card card, Organism target) throws IllegalOperationException;

    @Override
    public ProcessorType getProcessorType() {
        return PROCESSOR_TYPE;
    }
}
