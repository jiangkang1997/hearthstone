package com.jk.game.hearthstone.server.exception;

/**
 * @author jk
 * @date 2021/1/31 18:08
 */
public class IllegalInputException extends Exception{

    public IllegalInputException() {
        super();
    }

    public IllegalInputException(String message) {
        super(message);
    }
}
