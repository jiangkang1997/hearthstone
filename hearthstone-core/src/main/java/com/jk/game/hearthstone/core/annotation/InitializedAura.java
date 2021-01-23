package com.jk.game.hearthstone.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动注册的光环
 * 当一张卡牌拥有标注有此注解的光环时，当其入场时，光环会自动注册至 {@link com.jk.game.hearthstone.core.data.Desktop}
 * 入场的定义：
 * @see com.jk.game.hearthstone.core.handler.JoinHandler
 *
 * @author  jk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InitializedAura {
}
