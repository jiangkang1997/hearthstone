package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;

import java.io.Serializable;

/**
 * 所有处理器的基础接口
 * 处理器拦截一个特定的事件，并在该事件进行前/后 执行其特定的处理方法
 *
 * @author jk
 */
public interface Processor extends Serializable {

    /**
     * 返回该处理器的拥有者
     * @return 处理器的拥有者
     */
    Card getOwner();


    /**
     * 获取处理器类型
     * @return 处理器类型
     */
    ProcessorType getProcessorType();
}
