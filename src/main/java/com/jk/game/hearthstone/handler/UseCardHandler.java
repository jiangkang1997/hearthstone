package com.jk.game.hearthstone.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.common.SpringUtil;
import com.jk.game.hearthstone.config.UseCardPreprocessor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

import java.util.List;
import java.util.Map;

/**
 * 掌管整个出牌阶段的生命周期
 *
 * @author jk
 */
public class UseCardHandler {


    public void usrCard(Desktop desktop,Card card, Organism target) throws IllegalOperationException {
        //前置处理器检查操作合法性
        doUseCardPreprocessor(desktop,card,target);
        //费用扣除
        Player player = desktop.getPlayer(card.getPlayerType());
        player.costPower(card.getCost(),card.getOverload());
        //移除手牌
        //todo 移除手牌事件处理器 移除手牌应由独立的板块负责，用于适配弃牌效果
        List<Card> cards = desktop.getCards(card.getPlayerType());
        cards.remove(card);
        //入场
        //todo：目前入场的随从被默认放在最右侧，暂时不支持选择随从入场位置
        List<Minion> minions = desktop.getMinions(card.getPlayerType());
        //minions.add(card);
    }

    private void doUseCardPreprocessor(Desktop desktop, Card card, Organism target) throws IllegalOperationException {
        Map<String, UseCardPreprocessor> playPreprocessors = SpringUtil.getPlayPreprocessors();
        for (UseCardPreprocessor preprocessor : playPreprocessors.values()) {
            preprocessor.processBeforePlay(desktop,card, target);
        }
    }

}
