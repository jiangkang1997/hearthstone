package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.arms.Arms;
import com.jk.game.hearthstone.card.magic.secret.Secret;
import com.jk.game.hearthstone.card.magic.task.Task;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.JoinType;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import com.jk.game.hearthstone.exception.InvalidOperationException;

import java.util.List;

/**
 * 卡牌入场操作的处理者
 *
 * 入场的定义：
 * 包括武器的装备，随从进入桌面（使用，召唤和招募）
 * 以及常规魔法，奥秘，任务，英雄的使用
 * 需要注意的是：常规魔法是一次性效果，本身没有入场操作，但需要进行入场前拦截（法术反制）
 *
 * @author jk
 */
public class JoinHandler {

    private static final int MAX_MINION_NUM = 7;
    private static final int MAX_TASK_SECRET_NUM = 5;

    /**
     * 卡牌的入场
     * @param desktop
     * @param card
     */
    public static void join(Desktop desktop, Card card) throws InvalidOperationException {
        doJoinPreprocessor(desktop, card);
        if (card instanceof Arms) {
            doArmsJoin(desktop, (Arms) card);
        } else if (card instanceof Task || card instanceof Secret) {
            doTaskAndSecretJoin(desktop,card);
        } else if (card instanceof Hero) {
            doHeroJoin(desktop, card);
        } else if (card instanceof Minion) {
            doMinionJoin(desktop, (Minion) card);
        }
        doJoinPostProcessor(desktop, card);
    }

    private static void doJoinPreprocessor(Desktop desktop,Card card) throws InvalidOperationException {
        //todo：入场前置 例如法术反制，强制使法术无法入场
    }

    private static void doArmsJoin(Desktop desktop,Arms arms){
        Player player = desktop.getPlayer(arms.getPlayerType());
        player.setArms(arms);
        //todo: 武器的入场，替换原有的武器，并触发原有武器的亡语
    }

    private static void doTaskAndSecretJoin(Desktop desktop,Card card){
        //todo: 奥秘和任务的入场
    }

    private static void doHeroJoin(Desktop desktop, Card card){
        //todo: 英雄入场，替换英雄
    }

    private static void doMinionJoin(Desktop desktop,Minion minion){
        //todo：目前入场的随从被默认放在最右侧，暂时不支持选择随从入场位置
        List<Minion> minions = desktop.getMinions(minion.getPlayerType());
        if(minions.size() < MAX_MINION_NUM){
            minions.add(minion);
        }
    }

    private static void doJoinPostProcessor(Desktop desktop,Card card){
        //todo: 入场后置 （鱼人招潮者）使用，召唤，招募都算
    }
}
