package com.jk.game.hearthstone.core.annotation;

import java.lang.annotation.*;

/**
 * 自动注册的处理器
 * 当一张卡牌拥有标注有此注解的处理器时，当其入场时，该处理器会自动注册至 {@link com.jk.game.hearthstone.core.processer.ProcessorManager}
 * 入场的定义：
 * @see com.jk.game.hearthstone.core.handler.JoinHandler
 *
 * @author jk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InitializedProcessor {
}
