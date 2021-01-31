package com.jk.game.hearthstone.server.service;

import com.jk.game.hearthstone.server.exception.IllegalInputException;
import com.jk.game.hearthstone.server.exception.NoSuchCommandException;
import com.jk.game.hearthstone.server.model.Command;

/**
 * @author jk
 * @date 2021/1/31 17:55
 */
public interface CommandParseService {

    /**
     * 将用户输入转化为具体命令对象
     * @param input
     * @return
     * @throws IllegalInputException 非法输入
     */
    Command commandParse(String input) throws IllegalInputException, NoSuchCommandException;
}
