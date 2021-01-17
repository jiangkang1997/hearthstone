package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.common.CardCollection;
import com.jk.game.hearthstone.config.BattleCry;
import com.jk.game.hearthstone.config.Combo;
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

    /**
     * 使用卡牌
     * @param desktop
     * @param card 使用的卡牌
     * @param target 战吼或者法术效果指向的目标
     * @param seat 使用随从卡牌时，指定的随从站位
     * @throws IllegalOperationException 非法操作
     */
    public static void usrCard(Desktop desktop, Card card, Organism target,Integer seat) throws IllegalOperationException {
        //todo：死亡计算时机
        try {
            //前置处理器检查操作合法性
            doUseCardPreprocessor(desktop, card, target);
            //费用扣除
            Player player = desktop.getPlayer(card.getPlayerType());
            player.costPower(card.getCost(), card.getOverload());
            //移除手牌
            CardCollection cards = desktop.getCards(card.getPlayerType());
            cards.remove(card);
            //入场
            JoinHandler.join(desktop, card,seat);
            //触发法术效果/战吼/连击/流放/初始化buff
            executeEffect(desktop, card, target);
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


    private static void doUseCardPostProcessor(Desktop desktop, Card card) throws IllegalAccessException, InstantiationException {
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.POST_USE_CARD);
        for (Processor preprocessor : processors) {
            ((AbstractUseCardPostProcessor) preprocessor).processAfterPlay(desktop, card);
        }
    }

    private static void executeEffect(Desktop desktop,Card card,Organism target){
        //触发连击效果，连击效果优先级最高且会覆盖其他效果
        boolean isCombo = desktop.getHistory().getCurrentTurn().getUseNum() >= 1;
        if(isCombo && card instanceof Combo){
            ((Combo) card).combo(desktop, target);
            return;
        }
        //触发法术效果
        if (card instanceof NormalMagic) {
            ((NormalMagic) card).effect(desktop, target);
        }
        //触发战吼效果
        else if (card instanceof BattleCry) {
            ((BattleCry) card).effect(desktop, target);
        }
        //todo：流放
    }

}
