package com.jk.game.hearthstone.server.service;

import com.jk.game.hearthstone.server.constant.CommandType;
import com.jk.game.hearthstone.server.model.Command;

/**
 * @author jk
 * @date 2021/2/13 19:29
 */
public interface CommandDispatcherService {

    /**
     * 将命令分发给具体的service
     * @param commandType
     * @return
     */
    CommandService dispatcher(CommandType commandType);

}
