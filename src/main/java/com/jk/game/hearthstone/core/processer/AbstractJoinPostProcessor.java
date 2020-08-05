package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;

/**
 * 出牌后置处理器
 * 随从/法术 在以任何形式入场后，会触发 processAfterJoin 方法
 *
 * @author jk
 */
public abstract class AbstractJoinPostProcessor {

    private final ProcessorType PROCESSOR_TYPE = ProcessorType.POST_JOIN;

    /**
     * 在入场操作后触发
     *
     * @param desktop 桌面环境
     * @param card 使用的卡牌
     */
    public abstract void processAfterJoin(Desktop desktop, Card card) throws InstantiationException, IllegalAccessException;
}
