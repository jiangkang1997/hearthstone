package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.arms.Arms;
import com.jk.game.hearthstone.card.magic.secret.Secret;
import com.jk.game.hearthstone.card.magic.task.Task;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.config.BattleCry;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.core.processer.UseCardPreprocessor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

import java.util.List;
import java.util.Map;

/**
 * 掌管整个出牌阶段的生命周期
 *
 * @author jk
 */
public class UseCardHandler {

    public static void usrCard(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        //前置处理器检查操作合法性
        doUseCardPreprocessor(desktop, card, target);
        //费用扣除
        Player player = desktop.getPlayer(card.getPlayerType());
        player.costPower(card.getCost(), card.getOverload());
        //移除手牌
        List<Card> cards = desktop.getCards(card.getPlayerType());
        cards.remove(card);
        //todo: 入场拦截 类似于法反，已使用了卡牌但不能入场
        //入场
        join(desktop, card);
        //战吼
        doBattleCry(desktop, card, target);
    }

    private static void doUseCardPreprocessor(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_USE_CARD);
        for (Processor preprocessor : processors) {
            ((UseCardPreprocessor)preprocessor).processBeforePlay(desktop, card, target);
        }
    }

    private static void join(Desktop desktop, Card card) {
        if (card instanceof Arms) {
            //todo: 武器的入场，替换原有的武器，并触发原有武器的亡语
        } else if (card instanceof Task || card instanceof Secret) {
            //todo: 奥秘和任务的入场
        } else if (card instanceof Hero) {
            //todo: 英雄入场，替换英雄
        } else if (card instanceof Minion) {
            //todo：目前入场的随从被默认放在最右侧，暂时不支持选择随从入场位置
            List<Minion> minions = desktop.getMinions(card.getPlayerType());
            minions.add((Minion) card);
        }
    }

    private static void doBattleCry(Desktop desktop, Card card, Organism target) {
        if (card instanceof BattleCry) {
            ((BattleCry) card).effect(desktop, target);
        }
        //todo: 战吼后置处理，死亡结算
    }

}
