package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.enumeration.ActionType;
import lombok.Data;

import static com.jk.game.hearthstone.enumeration.ActionType.*;

/**
 * @author jk
 */
@Data
public class Action {

    public ActionType actionType;
    public Card card;
    public Organism target;

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
}
