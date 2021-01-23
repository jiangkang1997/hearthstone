package com.jk.game.hearthstone.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 被标记的属性表示该属性是当前回合有效的，回合切换后会重置
 * @author jk
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentTurn {
}
