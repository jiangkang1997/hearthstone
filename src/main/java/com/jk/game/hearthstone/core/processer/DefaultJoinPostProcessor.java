package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.annotation.InitializedAura;
import com.jk.game.hearthstone.annotation.InitializedProcessor;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.core.aura.Aura;
import com.jk.game.hearthstone.data.Desktop;

/**
 * 默认的入场后置处理器
 * 主要用于注册卡牌所携带的处理器和光环效果
 *
 * @author jk
 */
public class DefaultJoinPostProcessor extends AbstractJoinPostProcessor {

    @Override
    public void processAfterJoin(Desktop desktop, Card card) throws InstantiationException, IllegalAccessException {
        registerAura(desktop, card);
        registerProcessor(desktop, card);
    }

    private void registerProcessor(Desktop desktop, Card card) throws IllegalAccessException, InstantiationException {
        Class<?>[] classes = card.getClass().getDeclaredClasses();
        if (classes.length != 0) {
            for (Class<?> clazz : classes) {
                if (Processor.class.isAssignableFrom(clazz) && clazz.getAnnotation(InitializedProcessor.class) != null) {
                    Processor processor = (Processor) clazz.newInstance();
                    processor.setOwner(card);
                    desktop.getProcessorManager().register(processor);
                }
            }
        }
    }

    private void registerAura(Desktop desktop,Card card) throws IllegalAccessException, InstantiationException {
        Class<?>[] classes = card.getClass().getDeclaredClasses();
        if (classes.length != 0) {
            for (Class<?> clazz : classes) {
                if (Aura.class.isAssignableFrom(clazz) && clazz.getAnnotation(InitializedAura.class) != null) {
                    Aura aura = (Aura) clazz.newInstance();
                    aura.setOwner(card);
                    desktop.getAuraManager().register(aura);
                }
            }
        }
    }
}
