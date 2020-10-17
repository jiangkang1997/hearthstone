package com.jk.game.hearthstone.data;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏的历史纪录
 * @author jk
 */
@Data
public class History implements Serializable {

    /**
     * 当前回合
     */
    private Turn currentTurn;

    /**
     * 上个回合
     */
    private Turn lastTurn;

    /**
     * 历史回合
     */
    private List<Turn> historicalTurn = new ArrayList<>();

    public void record(Action action){
        if(currentTurn == null){
            currentTurn = new Turn();
        }
        currentTurn.actions.add(action);
    }

    /**
     * 下一回合
     */
    public void nextTurn(){
        if(lastTurn != null){
            historicalTurn.add(lastTurn);
        }
        lastTurn = currentTurn == null ? new Turn() : currentTurn;
    }

    /**
     * @return 当前回合数
     */
    public int getCurrentTurnNo(){
        return lastTurn == null ? 1 : historicalTurn.size()+2;
    }

    public Turn getCurrentTurn(){
        if (currentTurn == null) {
            currentTurn = new Turn();
        }
        return currentTurn;
    }
}
