package com.jk.game.hearthstone.data;

import lombok.Data;
import org.springframework.util.CollectionUtils;

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
    private Turn currentTurn = new Turn();

    /**
     * 上个回合
     */
    private Turn lastTurn = new Turn();

    /**
     * 历史回合
     */
    private List<Turn> historicalTurn = new ArrayList<>();

    private History duplicate;

    @Override
    public Object clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (History) super.clone();
            duplicate.historicalTurn = new ArrayList<>();
            duplicate.currentTurn = currentTurn.clone();
            duplicate.lastTurn = lastTurn.clone();
            if(!CollectionUtils.isEmpty(historicalTurn)){
                for (Turn turn : historicalTurn) {
                    duplicate.historicalTurn.add(turn.clone());
                }
            }
        }
        return duplicate;
    }
}
