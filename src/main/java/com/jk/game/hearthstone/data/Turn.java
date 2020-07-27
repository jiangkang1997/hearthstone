package com.jk.game.hearthstone.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 回合信息
 * @author jk
 */
@Data
public class Turn {

    public Integer playNum = 0;
    public List<Action> actions = new ArrayList<>();

    public void print() {
        for (Action action : actions) {
            System.out.println(action.toString());
        }
    }
}
