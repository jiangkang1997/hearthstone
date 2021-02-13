package com.jk.game.hearthstone.server.service.impl;

import com.jk.game.hearthstone.server.annotation.Command;
import com.jk.game.hearthstone.server.constant.CommandType;
import com.jk.game.hearthstone.server.service.CommandService;
import org.springframework.stereotype.Component;

/**
 * @author jk
 * @date 2021/2/13 19:50
 */
@Component
@Command(COMMAND_TYPE = CommandType.MINIONS)
public class MinionsCommandServiceImpl implements CommandService {
    @Override
    public String doCommand() {
        System.out.println("minions command execute");
        return null;
    }
}
