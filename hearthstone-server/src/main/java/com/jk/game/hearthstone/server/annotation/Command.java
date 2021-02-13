package com.jk.game.hearthstone.server.annotation;

import com.jk.game.hearthstone.server.constant.CommandType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    CommandType COMMAND_TYPE();
}
