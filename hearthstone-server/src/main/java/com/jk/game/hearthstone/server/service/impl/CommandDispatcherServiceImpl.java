package com.jk.game.hearthstone.server.service.impl;

import com.jk.game.hearthstone.server.constant.CommandType;
import com.jk.game.hearthstone.server.service.CommandDispatcherService;
import com.jk.game.hearthstone.server.service.CommandService;
import com.jk.game.hearthstone.server.util.SpringContextUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jk
 * @date 2021/2/13 19:45
 */
@Component
public class CommandDispatcherServiceImpl implements CommandDispatcherService {

    private Map<CommandType,CommandService> commandServices = new HashMap<>();
    @Resource
    private SpringContextUtil springContextUtil;

    @PostConstruct
    private void inti(){
        Map<String, CommandService> beanByType = springContextUtil.getBeanByType(CommandService.class);
        for (Map.Entry<String, CommandService> entry : beanByType.entrySet()) {
            com.jk.game.hearthstone.server.annotation.Command annotation = entry.getValue().getClass().getAnnotation(com.jk.game.hearthstone.server.annotation.Command.class);
            if(annotation != null){
                CommandType commandType = annotation.COMMAND_TYPE();
                commandServices.put(commandType,entry.getValue());
            }
        }
    }

    @Override
    public CommandService dispatcher(CommandType commandType) {
        return commandServices.get(commandType);
    }
}
