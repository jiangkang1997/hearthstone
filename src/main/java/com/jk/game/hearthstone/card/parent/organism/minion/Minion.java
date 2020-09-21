package com.jk.game.hearthstone.card.parent.organism.minion;


import com.jk.game.hearthstone.card.parent.organism.Organism;
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
public class Minion extends Organism{

    /**
     * 冲锋
     */
    protected boolean charge = false;

    /**
     * 副本
     */
    private Minion duplicate;

    public Minion(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType){
        super(desktop,cost, attack, health, name, desc, cardType);
    }


    @Override
    public Minion clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (Minion) super.clone();
        }
        return duplicate;
    }
}
