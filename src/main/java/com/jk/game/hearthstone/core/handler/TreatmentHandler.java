package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.processer.AbstractTreatmentPostProcess;
import com.jk.game.hearthstone.core.processer.Processor;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.ProcessorType;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;

/**
 * @author jk
 * @date 2021/1/10 16:03
 */
public class TreatmentHandler {

    public static void doTreatment(Desktop desktop, Card source, Organism target,int num){
        if(target.getHealth() >= target.getMaxHealth()){
            return;
        }
        target.setHealth(target.getHealth() + num);
        if(target.getHealth() > target.getMaxHealth()){
            target.setHealth(target.getMaxHealth());
        }
        doTreatmentPostProcess(desktop, source, target, num);

    }


    private static void doTreatmentPostProcess(Desktop desktop,Card source,Organism target,int num){
        List<Processor> processors = desktop.getProcessorManager().getProcessors(ProcessorType.POST_TREAT);
        for (Processor processor : processors) {
            ((AbstractTreatmentPostProcess)processor).processAfterTreatment(desktop, source, target, num);
        }
    }
}
