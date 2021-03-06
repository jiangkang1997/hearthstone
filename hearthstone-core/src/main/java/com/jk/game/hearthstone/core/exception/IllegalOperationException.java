package com.jk.game.hearthstone.core.exception;

/**
 * 用户尝试做出不符合游戏规则的操作时，抛出此异常
 *
 * @author jk
 */
public class IllegalOperationException extends Exception {

    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }
}
