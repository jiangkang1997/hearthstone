package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.processer.AbstractHurtPostProcess;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.ProcessorType;
import com.jk.game.hearthstone.core.exception.InvalidHurtException;

import java.util.List;

/**
 * @author jk
 * @date 2021/1/10 15:39
 */
public class HurtHandler {

    /**
     * 造成伤害的处理
     *
     * @param desktop
     * @param source
     * @param target
     * @param num
     */
    public static void doHurt(Desktop desktop, Card source, Organism target, int num) {
        if (num == 0 || target.isImmune()) {
            return;
        }
        if (target instanceof Hero) {
            hurtHero((Hero) target, num);
        } else if (target instanceof Minion) {
            try {
                hurtMinion((Minion) target, num);
            } catch (InvalidHurtException ignore) {}
        }
        doHurtPostProcess(desktop, source, target, num);
    }

    private static void hurtHero(Hero target, int num) {
        if (target.getArmor() == 0) {
            target.setHealth(target.getHealth() - num);
        } else {
            target.setArmor(target.getArmor() - num);
            if (target.getArmor() < 0) {
                target.setHealth(target.getHealth() + target.getArmor());
                target.setArmor(0);
            }
        }
    }

    private static void hurtMinion(Minion target, int num) throws InvalidHurtException {
        if (target.isHolyShield()) {
            target.setHolyShield(false);
            //抛出无效伤害的异常，限制伤害后置处理器的执行
            throw new InvalidHurtException();
        }
        else{
            target.setHealth(target.getHealth() - num);
        }
    }

    private static void doHurtPostProcess(Desktop desktop,Card source,Organism target,int num){
        List<Processor> processes = desktop.getProcessorManager().getProcessors(ProcessorType.POST_HURT);
        for (Processor process : processes) {
            ((AbstractHurtPostProcess) process).processAfterHurt(desktop, source, target, num);
        }
    }
}
