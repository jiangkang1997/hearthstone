package com.jk.game.hearthstone.core.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 回合信息
 * @author jk
 */
@Data
public class Turn implements Serializable {

    /**
     * 当前回合已使用的卡牌数量
     * 作为连击和大范等的判断依据
     */
    private Integer useNum = 0;

    public List<Action> actions = new ArrayList<>();

    public void print() {
        for (Action action : actions) {
            System.out.println(action.toString());
        }
    }
}
