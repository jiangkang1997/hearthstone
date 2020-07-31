package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.magic.normal.NormalMagic;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.config.BattleCry;
import com.jk.game.hearthstone.core.processer.AbstractUseCardPostProcessor;
import com.jk.game.hearthstone.core.processer.AbstractUseCardPreprocessor;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import com.jk.game.hearthstone.exception.InvalidOperationException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 掌管整个出牌阶段的生命周期
 *
 * @author jk
 */
@Slf4j
public class UseCardHandler {

    public static void usrCard(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        //todo：死亡计算时机
        try {
            //前置处理器检查操作合法性
            doUseCardPreprocessor(desktop, card, target);
            //费用扣除
            Player player = desktop.getPlayer(card.getPlayerType());
            player.costPower(card.getCost(), card.getOverload());
            //移除手牌
            List<Card> cards = desktop.getCards(card.getPlayerType());
            cards.remove(card);
            //入场
            JoinHandler.join(desktop, card);
            //触发法术效果或者战吼
            if (card instanceof NormalMagic) {
                ((NormalMagic) card).effect(desktop, target);
            } else {
                doBattleCry(desktop, card, target);
            }
            //出牌后置处理
            doUseCardPostProcessor(desktop, card);
        } catch (InvalidOperationException ignored) {
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("实例化处理器失败");
            e.printStackTrace();
        }
    }

    private static void doUseCardPreprocessor(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.PRE_USE_CARD);
        for (Processor preprocessor : processors) {
            ((AbstractUseCardPreprocessor) preprocessor).processBeforePlay(desktop, card, target);
        }
    }


    private static void doBattleCry(Desktop desktop, Card card, Organism target) {
        //todo:战吼前置 作用比较少，沙德沃克和苔丝在战吼前需要获得战吼效果，需要用到战吼前置
        if (card instanceof BattleCry) {
            ((BattleCry) card).effect(desktop, target);
        }
        //todo: 战吼后置处理，（死亡结算？）
    }

    private static void doUseCardPostProcessor(Desktop desktop, Card card) throws IllegalAccessException, InstantiationException {
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.POST_USE_CARD);
        for (Processor preprocessor : processors) {
            ((AbstractUseCardPostProcessor) preprocessor).processAfterPlay(desktop, card);
        }
    }

}
