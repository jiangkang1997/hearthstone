package com.jk.game.hearthstone.server.service.impl;

import com.jk.game.hearthstone.server.constant.CommandType;
import com.jk.game.hearthstone.server.exception.IllegalInputException;
import com.jk.game.hearthstone.server.exception.NoSuchCommandException;
import com.jk.game.hearthstone.server.model.Command;
import com.jk.game.hearthstone.server.service.CommandParseService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @date 2021/1/31 18:06
 */
@Component
@Service
public class CommandParseServiceImpl implements CommandParseService {

    @Override
    public Command commandParse(String input) throws NoSuchCommandException, IllegalInputException {
        input = input.trim();
        if(StringUtils.isEmpty(input)){
            throw new IllegalInputException();
        }
        String[] split = input.split("-");
        if(split.length>2){
            throw new IllegalInputException();
        }
        Command command = new Command();
        //获取命令
        try {
            command.setCommandType(CommandType.valueOf(split[0].toUpperCase()));
        }catch (Exception e){
            throw new NoSuchCommandException(split[0]);
        }
        //获取选项
        List<Character> options = new ArrayList<>();
        if(split.length==1){
            options.add(command.getCommandType().getDefaultOption());
        }
        else {
            char[] chars = split[1].toCharArray();
            for (char aChar : chars) {
                options.add(aChar);
            }
        }
        command.setOptions(options);
        return command;
    }
}
