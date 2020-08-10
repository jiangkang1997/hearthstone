package com.jk.game.hearthstone.card.organism.minion;


import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 所有随从的基类
 *
 * @author jk
 */
@Getter
@Setter
@NoArgsConstructor
public class Minion extends Organism implements Cloneable {

    /**
     * 冲锋
     */
    protected boolean charge = false;

    public Minion(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType){
        super(desktop,cost, attack, health, name, desc, cardType);
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
