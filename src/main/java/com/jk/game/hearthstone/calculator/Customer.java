package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.handler.HeroSkillHandler;
import com.jk.game.hearthstone.core.handler.SimpleAttackHandler;
import com.jk.game.hearthstone.core.handler.UseCardHandler;
import com.jk.game.hearthstone.data.Action;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ActionType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * 操作的消费者
 *
 * @author jk
 * @date 2020/8/12 21:29
 */
public class Customer {

    public static void doOperation(Desktop desktop, Action action) throws IllegalOperationException {
        //攻击操作
        //todo: 正式的攻击处理器还未完成，先用简单的测试
        if(action.getActionType() == ActionType.ACTION_TYPE_ATTACK){
            SimpleAttackHandler.doAttack((Organism) action.getCard(),action.getTarget());
        }
        //使用卡牌操作
        else if(action.getActionType() == ActionType.ACTION_TYPE_USE){
            UseCardHandler.usrCard(desktop,action.getCard(),action.getTarget());
        }
        //英雄技能操作
        else if(action.getActionType() == ActionType.ACTION_TYPE_SKILL){
            HeroSkillHandler.doHeroSkill(desktop,(Hero) action.getCard(),action.getTarget());
        }
    }
}
