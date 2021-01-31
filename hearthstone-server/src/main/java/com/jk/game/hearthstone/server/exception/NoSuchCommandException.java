package com.jk.game.hearthstone.server.exception;

/**
 * @author jk
 * @date 2021/1/31 18:29
 */
public class NoSuchCommandException extends Exception {

    public NoSuchCommandException() {
        super();
    }

    public NoSuchCommandException(String message) {
        super(message);
    }
}
