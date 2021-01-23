package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.handler.TreatmentHandler;
import com.jk.game.hearthstone.core.data.Desktop;

/**
 * @author jk
 * @date 2021/1/10 16:21
 */
public class DefaultHurtPostProcess extends AbstractHurtPostProcess {

    public DefaultHurtPostProcess(Card owner) {
        super(owner);
    }

    @Override
    public void processAfterHurt(Desktop desktop, Card source, Organism target, int num) {
        //吸血
        doBloodSucking(desktop, source, num);
        //剧毒
        doHighlyToxic(source,target);
    }

    private void doBloodSucking(Desktop desktop,Card source,int num){
        boolean canBloodSucking = (source instanceof Minion && ((Minion) source).isBloodSucking()) ||
                (source instanceof Hero &&
                        desktop.getPlayer(source.getPlayerType()).getArms() != null &&
                        desktop.getPlayer(source.getPlayerType()).getArms().isBloodSucking());
        if(canBloodSucking){
            Hero treatTarget = desktop.getPlayer(source.getPlayerType()).getHero();
            TreatmentHandler.doTreatment(desktop,source,treatTarget,num);
        }
    }

    private void doHighlyToxic(Card source,Organism target){
        if(source instanceof Minion && ((Minion) source).isHighlyToxic()){
            if(target instanceof Minion){
                target.setLife(0);
            }
        }
    }

}
