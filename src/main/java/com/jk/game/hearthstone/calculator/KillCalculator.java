package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.card.classic.mage.FrostArrow;
import com.jk.game.hearthstone.card.classic.mage.IceSpear;
import com.jk.game.hearthstone.card.classic.mage.ManaDragon;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.hero.Rouge;
import com.jk.game.hearthstone.core.handler.JoinHandler;
import com.jk.game.hearthstone.data.Action;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import com.jk.game.hearthstone.exception.InvalidOperationException;
import com.jk.game.hearthstone.util.DeepCloneUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * @author jk
 */
@Slf4j
public class KillCalculator {

    public static void main(String[] args) throws IllegalOperationException, IOException, ClassNotFoundException, IllegalAccessException, InvalidOperationException, InstantiationException {
        Desktop desktop = DesktopConstruct.desktop1_1();
        dfs(desktop);
    }

    private static void dfs(Desktop desktop) throws IllegalOperationException, IOException, ClassNotFoundException {
        List<Action> actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN);
        log(actions, "当前所有操作：");
        //深度克隆一份controller的副本，以便回溯时回到初始状态
        Desktop duplicate = (Desktop) DeepCloneUtil.deepClone(desktop);
        //出口
        if (desktop.getSecondPlayer().getHero().getHealth() <= 0) {
            log(desktop.getHistory().getCurrentTurn().actions, "成功");
        }
        //收工了
        if (actions.size() == 0) {
            log(desktop.getHistory().getCurrentTurn().actions, "收工了，回溯");
            return;
        }
        for (int index = 0; index < actions.size() ; index++) {
            desktop.getHistory().record(actions.get(index));
            Customer.doOperation(desktop,actions.get(index));
            log(desktop.getHistory().getCurrentTurn().actions, "出牌顺序");
            log.info("水晶数：" + desktop.getMainPlayer().getPower());
            log.info("敌方血量：" + desktop.getSecondPlayer().getHero().getHealth());
            dfs(desktop);
            //将备份的desktop拿回，回到原始状态
            desktop = duplicate;
            duplicate = (Desktop) DeepCloneUtil.deepClone(duplicate);
            actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN);
            log(desktop.getHistory().getCurrentTurn().actions, "回溯");
        }
    }


    private static void log(List<Action> actions, String info) {
        System.out.println(info);
        for (Action action : actions) {
            System.out.println(action.toString());
        }
        System.out.println("-------------------------------------");
    }

}
