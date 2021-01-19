package com.jk.game.hearthstone.calculator;

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

    /**
     * 是否无视随从站位
     */
    private static final boolean IGNORE_SEAT = false;
    /**
     * 日志等级 1：只保留成功， 2:保留调试信息
     */
    private static final int LOG_LEVEL = 1;

    public static void main(String[] args) throws IllegalOperationException, IOException, ClassNotFoundException, IllegalAccessException, InvalidOperationException, InstantiationException {
        long start = System.currentTimeMillis();
        Desktop desktop = DesktopConstruct.desktop1_4();
        dfs(desktop);
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    private static void dfs(Desktop desktop) throws IllegalOperationException, IOException, ClassNotFoundException {
        List<Action> actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN,IGNORE_SEAT);
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
            //log.info("水晶数：" + desktop.getMainPlayer().getPower());
            //log.info("敌方血量：" + desktop.getSecondPlayer().getHero().getHealth());
            dfs(desktop);
            //将备份的desktop拿回，回到原始状态
            desktop = duplicate;
            duplicate = (Desktop) DeepCloneUtil.deepClone(duplicate);
            actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN,IGNORE_SEAT);
            log(desktop.getHistory().getCurrentTurn().actions, "回溯");
        }
    }

    private static void log(List<Action> actions, String info) {
        if(!info.equals("成功") && LOG_LEVEL < 2 ){
            return;
        }
        System.out.println(info);
        for (Action action : actions) {
            System.out.println(action.toString());
        }
        System.out.println("-------------------------------------");
    }

}
