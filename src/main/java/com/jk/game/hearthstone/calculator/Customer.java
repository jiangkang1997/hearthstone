package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.handler.HeroSkillHandler;
import com.jk.game.hearthstone.core.handler.SimpleAttackHandler;
import com.jk.game.hearthstone.core.handler.UseCardHandler;
import com.jk.game.hearthstone.data.Action;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ActionType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

import java.util.ArrayList;
import java.util.List;

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
        //死亡结算 这里只结算死亡的随从
        List<Minion> mainGraveyard = new ArrayList<>();
        List<Minion> secondGraveyard = new ArrayList<>();
        for (Minion mainMinion : desktop.getMainMinions().getList()) {
            if(mainMinion.getHealth() <= 0 ){
                mainGraveyard.add(mainMinion);
            }
        }
        for (Minion secondMinion : desktop.getSecondMinions().getList()) {
            if(secondMinion.getHealth() <= 0){
                secondGraveyard.add(secondMinion);
            }
        }
        for (Minion minion : mainGraveyard) {
            desktop.getMainMinions().remove(minion);
        }
        for (Minion minion : secondGraveyard) {
            desktop.getSecondMinions().remove(minion);
        }
    }
}
