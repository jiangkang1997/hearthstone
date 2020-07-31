package com.jk.game.hearthstone.card.organism;


import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Superclass of all organisms
 *
 * @author jk
 */
@Getter
@Setter
@NoArgsConstructor
public class Organism extends Card implements Cloneable {

    protected Integer attack;
    protected Integer health;

    public Organism(int cost, int attack, int health, String name, String desc, CardType cardType){
        super(cost, name, desc, cardType);
        this.attack = attack;
        this.health = health;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
