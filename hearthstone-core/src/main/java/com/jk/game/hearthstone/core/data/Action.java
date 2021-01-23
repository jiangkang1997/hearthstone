package com.jk.game.hearthstone.core.data;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.enumeration.ActionType;
import lombok.Data;

import java.io.Serializable;

import static com.jk.game.hearthstone.core.enumeration.ActionType.*;

/**
 * @author jk
 */
@Data
public class Action implements Serializable {

    private ActionType actionType;
    private Card card;
    private Organism target;
    /**
     * 随从站位 默认最右
     */
    private Integer seat;

    public Action(ActionType actionType,Card card){
        this.actionType = actionType;
        this.card = card;
    }

    public Action(ActionType actionType, Card card, Organism target){
        this.actionType = actionType;
        this.card = card;
        this.target = target;
    }

    public Action(ActionType actionType, Card card, Organism target,Integer seat){
        this.actionType = actionType;
        this.card = card;
        this.target = target;
        this.seat = seat;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(actionType.equals(ACTION_TYPE_USE)){
            if(target ==null){
                result.append("出《").append(card.getName()).append("》");
            }else {
                result.append("出《").append(card.getName()).append("》 目标->《").append(target.getName()).append("》");
            }
            if(card instanceof Minion){
                if(seat == null){
                    result.append("位置：最右");
                }else {
                    result.append("位置：").append(seat);
                }
            }
        }else if(actionType.equals(ACTION_TYPE_ATTACK)){
            result.append("《").append(card.getName()).append("》 攻击 《").append(target.getName()).append("》");
        }else if(actionType.equals(ACTION_TYPE_SKILL)){
            if(target ==null){
                result.append("使用英雄技能");
            }else {
                result.append("使用英雄技能 目标->《").append(target.getName()).append("》");
            }
        }
        return result.toString();
    }
}
