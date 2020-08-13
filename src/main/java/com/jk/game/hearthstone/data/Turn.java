package com.jk.game.hearthstone.data;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 回合信息
 * @author jk
 */
@Data
public class Turn implements Cloneable {

    public Integer playNum = 0;
    public List<Action> actions = new ArrayList<>();

    /**
     * 副本
     */
    private Turn duplicate;

    public void print() {
        for (Action action : actions) {
            System.out.println(action.toString());
        }
    }

    @Override
    public Turn clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Turn) super.clone();
            duplicate.actions = new ArrayList<>();
            if(!CollectionUtils.isEmpty(actions)){
                for (Action action : actions) {
                    duplicate.actions.add(action.clone());
                }
            }
        }
        return duplicate;
    }
}
