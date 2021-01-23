package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.data.Desktop;

import java.util.Iterator;

/**
 * 死亡结算
 * @author jk
 * @date 2021/1/23 14:48
 */
public class DeathHandler {

    public static void doDeathHandler(Desktop desktop){

        Iterator<Minion> mainIterator = desktop.getMainMinions().iterator();
        Iterator<Minion> secondIterator = desktop.getSecondMinions().iterator();
        while (mainIterator.hasNext()){
            if(mainIterator.next().getHealth()<=0){
                mainIterator.remove();
            }
        }
        while (secondIterator.hasNext()){
            if(secondIterator.next().getHealth() <= 0){
                secondIterator.remove();
            }
        }
    }
}
