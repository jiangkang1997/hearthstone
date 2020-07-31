package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.annotation.InitializedProcessor;
import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.data.Desktop;

/**
 * 默认的出牌后置处理器
 * 目前用于注册卡牌的光环效果和处理器
 *
 * @author jk
 */
public class DefaultUseCardPostProcessor extends AbstractUseCardPostProcessor {

    @Override
    public void processAfterPlay(Desktop desktop, Card card) throws InstantiationException, IllegalAccessException {
        //todo: 注册光环
        registerProcessor(desktop, card);
    }

    private void registerProcessor(Desktop desktop, Card card) throws IllegalAccessException, InstantiationException {
        Class<?>[] classes = card.getClass().getClasses();
        if (classes.length != 0) {
            for (Class<?> clazz : classes) {
                if (Processor.class.isAssignableFrom(clazz) && clazz.getAnnotation(InitializedProcessor.class) != null) {
                    Processor processor = (Processor) clazz.newInstance();
                    desktop.getProcessorManager().register(processor);
                }
            }
        }
    }
}
