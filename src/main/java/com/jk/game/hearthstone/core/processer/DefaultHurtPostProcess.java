package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.arms.Arms;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.handler.TreatmentHandler;
import com.jk.game.hearthstone.data.Desktop;

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
        //死亡标记 先吸血后标记，战斗死亡的英雄因吸血生命值大于0的，不被判断为死亡
        deathMark(target);
    }

    private void doBloodSucking(Desktop desktop,Card source,int num){
        boolean canBloodSucking = (source instanceof Minion && ((Minion) source).isBloodSucking()) ||
                (source instanceof Arms && ((Arms) source).isBloodSucking());
        Hero treatTarget = desktop.getPlayer(source.getPlayerType()).getHero();
        TreatmentHandler.doTreatment(desktop,source,treatTarget,num);
    }

    private void doHighlyToxic(Card source,Organism target){
        if(source instanceof Minion && ((Minion) source).isHighlyToxic()){
            if(target instanceof Minion){
                target.setLife(0);
            }
        }
    }

    private void deathMark(Organism target){
        if(target.getHealth() <=  0){
            target.setLife(0);
        }
    }
}
