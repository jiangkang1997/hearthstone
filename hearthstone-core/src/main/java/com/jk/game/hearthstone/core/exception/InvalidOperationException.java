package com.jk.game.hearthstone.core.exception;

/**
 * 无效化的操作
 *
 * @author jk
 */
public class InvalidOperationException extends Exception {

    public InvalidOperationException(){
        super();
    }

    public InvalidOperationException(String message){
        super(message);
    }
}
