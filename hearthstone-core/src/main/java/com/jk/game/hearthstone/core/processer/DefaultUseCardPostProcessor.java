package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.data.Turn;
import com.jk.game.hearthstone.core.handler.DeathHandler;

/**
 * 默认的出牌后置处理器
 *
 * @author jk
 */
public class DefaultUseCardPostProcessor extends AbstractUseCardPostProcessor {

    public DefaultUseCardPostProcessor(Card owner) {
        super(owner);
    }

    @Override
    public void processAfterPlay(Desktop desktop, Card card){
        Turn currentTurn = desktop.getHistory().getCurrentTurn();
        currentTurn.setUseNum(currentTurn.getUseNum() + 1);

        //todo: 腐蚀
    }

}
