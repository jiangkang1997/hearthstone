package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.card.organism.hero.Mage;
import com.jk.game.hearthstone.data.Action;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.data.History;
import com.jk.game.hearthstone.data.Turn;
import com.jk.game.hearthstone.enumeration.ActionType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author jk
 */
@Slf4j
public class KillCalculator {

    private static History history = new History();

    public static void main(String[] args) throws CloneNotSupportedException, IllegalOperationException {
        Desktop desktop = init();
        dfs(desktop);
    }

    /**
     * 初始化环境
     */
    private static Desktop init() {
        Desktop desktop = new Desktop();

        Player mainPlayer = new Player();
        Hero mainHero = new Mage(desktop, PlayerType.PLAYER_TYPE_MAIN);
        mainPlayer.setHero(mainHero);
        desktop.setMainPlayer(mainPlayer);

        Player secondPlayer = new Player();
        Hero secondHero = new Hero(desktop, "敌人", PlayerType.PLAYER_TYPE_SECOND);
        secondPlayer.setHero(secondHero);
        desktop.setSecondPlayer(secondPlayer);

        secondHero.setHealth(10);
        mainPlayer.setPower(4);
        mainPlayer.setMaxPower(4);

        return desktop;
    }


    private static void dfs(Desktop desktop) throws CloneNotSupportedException, IllegalOperationException {
        Turn turn = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN);
        log(turn, "当前所有操作：");
        //深度克隆一份controller的副本，以便回溯时回到初始状态
        Desktop duplicate = desktop.clone();
        //出口
        if (desktop.getSecondPlayer().getHero().getHealth() <= 0) {
            log(history.getCurrentTurn(), "成功");
        }
        //收工了
        if (turn.actions.size() == 0) {
            log(history.getCurrentTurn(), "收工了，回溯");
            return;
        }
        for (Action action : turn.actions) {
            Customer.doOperation(desktop,action);
            log.info("水晶数：" + desktop.getMainPlayer().getPower());
            log.info("敌方血量：" + desktop.getSecondPlayer().getHero().getHealth());
            log(history.getCurrentTurn(), "出牌顺序");
            Desktop dfsDesktop = desktop.clone();
            dfs(dfsDesktop);
            //将备份的desktop拿回，回到原始状态
            desktop = duplicate.clone();
            back(action);
            log(history.getCurrentTurn(), "回溯");
        }
    }


    /**
     * 回溯方法
     * 主要功能是清除上一步的历史记录 desktop的回退由克隆完成
     *
     * @param action
     */
    private static void back(Action action) {
        //如果是出牌
        if (action.getActionType().equals(ActionType.ACTION_TYPE_USE)) {
            history.getCurrentTurn().playNum -= 1;
        }
        //清除历史记录
        if (history.getCurrentTurn().actions.size() > 0) {
            history.getCurrentTurn().actions.remove(history.getCurrentTurn().actions.size() - 1);
        }
    }

    private static void log(Turn turn, String info) {
        System.out.println(info);
        turn.print();
        System.out.println("-------------------------------------");
    }

}
