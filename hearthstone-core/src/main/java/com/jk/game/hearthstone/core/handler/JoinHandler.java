package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.Player;
import com.jk.game.hearthstone.core.card.parent.arms.Arms;
import com.jk.game.hearthstone.core.card.parent.magic.Secret;
import com.jk.game.hearthstone.core.card.parent.magic.Task;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.common.MinionCollection;
import com.jk.game.hearthstone.core.enumeration.PlayerType;
import com.jk.game.hearthstone.core.processer.AbstractJoinPostProcessor;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;
import com.jk.game.hearthstone.core.exception.InvalidOperationException;
import org.springframework.util.CollectionUtils;

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

    /**
     * 卡牌的入场
     * @param desktop
     * @param card
     * @param seat 随从入场的位置  默认最右
     */
    public static void join(Desktop desktop,Card card,PlayerType playerType, Integer seat) throws InvalidOperationException, InstantiationException, IllegalAccessException {
        doJoinPreprocessor(desktop, card);
        if (card instanceof Arms) {
            doArmsJoin(desktop, playerType,(Arms) card);
        } else if (card instanceof Task || card instanceof Secret) {
            doTaskAndSecretJoin(desktop,card);
        } else if (card instanceof Hero) {
            doHeroJoin(desktop, card);
        } else if (card instanceof Minion) {
            doMinionJoin(desktop, (Minion) card,playerType,seat);
        }
        doJoinPostProcessor(desktop, card);
    }



    private static void doJoinPreprocessor(Desktop desktop,Card card) throws InvalidOperationException {
        //todo：入场前置 例如法术反制，强制使法术无法入场
    }

    private static void doArmsJoin(Desktop desktop,PlayerType playerType,Arms arms){
        Player player = desktop.getPlayer(playerType);
        player.setArms(arms);
        //todo: 触发原有武器的亡语
    }

    private static void doTaskAndSecretJoin(Desktop desktop,Card card){
        //todo: 奥秘和任务的入场
    }

    private static void doHeroJoin(Desktop desktop, Card card){
        //todo: 英雄入场，替换英雄 护甲以及血量继承 部分自带血量的英雄就不继承（大王，罗斯）
    }

    private static void doMinionJoin(Desktop desktop,Minion minion,PlayerType playerType,Integer seat){
        //todo：如果随从有磁力 并且右侧随从是机械 需要触发磁力
        MinionCollection minions = desktop.getMinions(playerType);
        minions.add(minion,seat);
        minion.setBirthday(desktop.getHistory().getCurrentTurnNo());
    }

    private static void doJoinPostProcessor(Desktop desktop,Card card) throws IllegalAccessException, InstantiationException {
        //入场后置 （鱼人招潮者）使用，召唤，招募都算
        //以及注册卡牌所携带的处理器和光环效果
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.POST_JOIN);
        if(!CollectionUtils.isEmpty(processors)){
            for (Processor processor : processors) {
                ((AbstractJoinPostProcessor) processor).processAfterJoin(desktop, card);
            }
        }
    }
}
