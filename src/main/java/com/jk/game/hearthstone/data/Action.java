package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.BaseCard;
import com.jk.game.hearthstone.enumeration.ActionType;
import lombok.Data;

import static com.jk.game.hearthstone.enumeration.ActionType.*;

/**
 * @author jk
 */
@Data
public class Action {

    public ActionType actionType;
    public BaseCard initiator;
    public BaseCard target;

    public Action(ActionType actionType,BaseCard initiator){
        this.actionType = actionType;
        this.initiator = initiator;
    }

    public Action(ActionType actionType,BaseCard initiator,BaseCard target){
        this.actionType = actionType;
        this.initiator = initiator;
        this.target = target;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(actionType.equals(ACTION_TYPE_PLAY)){
            if(target ==null){
                result.append("出《").append(initiator.getClass().getSimpleName()).append("》");
            }else {
                result.append("出《").append(initiator.getClass().getSimpleName()).append("》 目标->《").append(target.getClass().getSimpleName()).append("》");
            }
        }else if(actionType.equals(ACTION_TYPE_ATTACK)){
            result.append("《").append(initiator.getClass().getSimpleName()).append("》 攻击 《").append(target.getClass().getSimpleName()).append("》");
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
