package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.enumeration.ActionType;
import lombok.Data;

import java.io.Serializable;

import static com.jk.game.hearthstone.enumeration.ActionType.*;

/**
 * @author jk
 */
@Data
public class Action implements Serializable {

    private ActionType actionType;
    private Card card;
    private Organism target;

    /**
     * 副本
     */
    private Action duplicate;

    public Action(ActionType actionType,Card card){
        this.actionType = actionType;
        this.card = card;
    }

    public Action(ActionType actionType, Card card, Organism target){
        this.actionType = actionType;
        this.card = card;
        this.target = target;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(actionType.equals(ACTION_TYPE_USE)){
            if(target ==null){
                result.append("出《").append(card.getClass().getSimpleName()).append("》");
            }else {
                result.append("出《").append(card.getClass().getSimpleName()).append("》 目标->《").append(target.getClass().getSimpleName()).append("》");
            }
        }else if(actionType.equals(ACTION_TYPE_ATTACK)){
            result.append("《").append(card.getClass().getSimpleName()).append("》 攻击 《").append(target.getClass().getSimpleName()).append("》");
        }else if(actionType.equals(ACTION_TYPE_SKILL)){
            if(target ==null){
                result.append("使用英雄技能");
            }else {
                result.append("使用英雄技能 目标->《").append(target.getClass().getSimpleName()).append("》");
            }
        }
        return result.toString();
    }

    @Override
    public Action clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Action) super.clone();
            if(card != null){
                duplicate.card = card.clone();
            }
            if(target != null){
                duplicate.target = target.clone();
            }
        }
        return duplicate;
    }
}
