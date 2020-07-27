package com.jk.game.hearthstone.card;

import com.jk.game.hearthstone.card.organism.hero.BaseHero;
import lombok.Data;

/**
 * @author jk
 */
@Data
public class Player implements Cloneable {

    private int power;
    private int maxPower;
    private BaseHero hero;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result = super.clone();
        if(hero != null){
            ((Player) result).hero = (BaseHero) hero.clone();
        }
        return result;
    }
}
