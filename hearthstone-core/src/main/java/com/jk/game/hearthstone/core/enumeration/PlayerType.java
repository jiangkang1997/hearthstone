package com.jk.game.hearthstone.core.enumeration;

/**
 * 游戏开始时，自动分配主玩家和次玩家。主玩家先手
 * 主玩家机制用于判断随从的所属
 *
 * @author jk
 */

public enum PlayerType {

    /**
     * 主玩家
     */
    PLAYER_TYPE_MAIN,

    /**
     * 次玩家
     */
    PLAYER_TYPE_SECOND;

    /**
     * 获取对手的类型
     * @return 对手的类型
     */
    public PlayerType getOpponentType(){
        if(this == PLAYER_TYPE_MAIN){
            return PLAYER_TYPE_SECOND;
        }else {
            return PLAYER_TYPE_MAIN;
        }
    }
}
