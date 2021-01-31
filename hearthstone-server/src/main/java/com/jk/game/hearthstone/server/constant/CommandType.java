package com.jk.game.hearthstone.server.constant;

import lombok.Getter;

/**
 * @author jk
 * @date 2021/1/31 17:40
 */
@Getter
public enum CommandType {

    MINIONS("查看随从 可选项：\n" +
            "-a 查看双方随从\n" +
            "-m 查看我方随从\n" +
            "-e 查看敌方随从", 'a');

    /**
     * 命令说明
     */
    private final String help;
    /**
     * 默认的选项
     */
    private final Character defaultOption;

    CommandType(String help, Character defaultOption) {
        this.help = help;
        this.defaultOption = defaultOption;
    }
}
