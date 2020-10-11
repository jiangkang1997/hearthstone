package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.card.classic.mage.FrostArrow;
import com.jk.game.hearthstone.card.classic.mage.IceSpear;
import com.jk.game.hearthstone.card.classic.mage.ManaDragon;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.hero.Mage;
import com.jk.game.hearthstone.data.Action;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.data.History;
import com.jk.game.hearthstone.enumeration.ActionType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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

        //手牌 两张寒冰箭 一张冰枪术
        FrostArrow frostArrow1 = new FrostArrow(desktop);
        FrostArrow frostArrow2 = new FrostArrow(desktop);
        IceSpear iceSpear = new IceSpear(desktop);
        frostArrow1.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        frostArrow2.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        iceSpear.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        desktop.getMainCards().add(frostArrow1);
        desktop.getMainCards().add(frostArrow2);
        desktop.getMainCards().add(iceSpear);

        //场上一张可攻击的法力伏龙
        ManaDragon manaDragon = new ManaDragon(desktop);
        manaDragon.setCanAttack(true);
        manaDragon.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        desktop.getMainMinions().add(manaDragon);

        return desktop;
    }


    private static void dfs(Desktop desktop) throws CloneNotSupportedException, IllegalOperationException {
        List<Action> actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN);
        log(actions, "当前所有操作：");
        //深度克隆一份controller的副本，以便回溯时回到初始状态
        Desktop duplicate = desktop.clone();
        //出口
        if (desktop.getSecondPlayer().getHero().getHealth() <= 0) {
            log(history.getCurrentTurn().actions, "成功");
        }
        //收工了
        if (actions.size() == 0) {
            log(history.getCurrentTurn().actions, "收工了，回溯");
            return;
        }
        for (int index = 0; index < actions.size() ; index++) {
            //todo: 由于desktop克隆了  所以actions需要重新生成一遍
            history.getCurrentTurn().actions.add(actions.get(index));
            Customer.doOperation(desktop,actions.get(index));
            log(history.getCurrentTurn().actions, "出牌顺序");
            log.info("水晶数：" + desktop.getMainPlayer().getPower());
            log.info("敌方血量：" + desktop.getSecondPlayer().getHero().getHealth());
            dfs(desktop);
            //将备份的desktop拿回，回到原始状态
            desktop = duplicate;
            duplicate = duplicate.clone();
            actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN);
            back(actions.get(index));
            log(history.getCurrentTurn().actions, "回溯");
        }
    }


    /**
     * 回溯方法
     * 主要功能是清除上一步的历史记录 desktop的回退由克隆完成
     *
     * @param action 此次操作
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

    private static void log(List<Action> actions, String info) {
        System.out.println(info);
        for (Action action : actions) {
            System.out.println(action.toString());
        }
        System.out.println("-------------------------------------");
    }

}
