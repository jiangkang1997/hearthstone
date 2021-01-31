package com.jk.game.herathstone.calculator;

import com.jk.game.hearthstone.core.data.Action;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;
import com.jk.game.hearthstone.core.exception.IllegalOperationException;
import com.jk.game.hearthstone.core.exception.InvalidOperationException;
import com.jk.game.hearthstone.core.util.DeepCloneUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;

/**
 * @author jk
 */
@Slf4j
public class KillCalculator {

    /**
     * 是否无视随从站位
     */
    private static final boolean IGNORE_SEAT = true;
    /**
     * 日志等级 1：只保留成功， 2:保留调试信息
     */
    private static final int LOG_LEVEL = 2;

    static FileOutputStream fileOutputStream;

    static {
        try {
            fileOutputStream = new FileOutputStream("D:\\projectDatas\\hearthstone\\test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public KillCalculator() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IllegalOperationException, IOException, ClassNotFoundException, IllegalAccessException, InvalidOperationException, InstantiationException {
        fileOutputStream.write("开始".getBytes());
        long start = System.currentTimeMillis();
        Desktop desktop = DesktopConstruct.desktop1_1();
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
            fileOutputStream.write(("水晶数：" + desktop.getMainPlayer().getPower()+"\n").getBytes());
            fileOutputStream.write(("敌方血量：" + desktop.getSecondPlayer().getHero().getHealth()+"\n").getBytes());
            dfs(desktop);
            //将备份的desktop拿回，回到原始状态
            desktop = duplicate;
            duplicate = (Desktop) DeepCloneUtil.deepClone(duplicate);
            actions = Producer.getPossibleAction(desktop, PlayerType.PLAYER_TYPE_MAIN,IGNORE_SEAT);
            log(desktop.getHistory().getCurrentTurn().actions, "回溯");
        }
    }

    private static void log(List<Action> actions, String info) throws IOException {
        if(!info.equals("成功") && LOG_LEVEL < 2 ){
            return;
        }
        fileOutputStream.write((info+"\n").getBytes());
        for (Action action : actions) {
            fileOutputStream.write(action.toString().getBytes());
            fileOutputStream.write("\n".getBytes());
        }
        fileOutputStream.write("-------------------------------------\n".getBytes());
        fileOutputStream.flush();
    }

}
