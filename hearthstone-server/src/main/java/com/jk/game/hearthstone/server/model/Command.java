package com.jk.game.hearthstone.server.model;

import com.jk.game.hearthstone.server.constant.CommandType;
import lombok.Data;

import java.util.List;

/**
 * @author jk
 * @date 2021/1/31 18:02
 */
@Data
public class Command {

    /**
     * 命令
     */
    private CommandType commandType;

    /**
     * 选项
     */
    private List<Character> options;
}
