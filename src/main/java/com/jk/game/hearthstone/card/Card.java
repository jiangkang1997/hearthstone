package com.jk.game.hearthstone.card;


import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Superclass of all cards
 *
 * @author jk
 */
@Data
@NoArgsConstructor
public class Card implements Cloneable {

    protected Desktop desktop;
    protected Integer cost;
    protected Integer overload = 0;
    protected CardType cardType;
    protected PlayerType playerType;
    protected String name;
    protected String desc;

    public Card(Desktop desktop,int cost, String name, String desc, CardType cardType){
        this.desktop = desktop;
        this.cost = cost;
        this.name = name;
        this.desc = desc;
        this.cardType = cardType;
    }

    public Integer getCost(){
        //todo 需要完成减费效果和加费效果的结算
        return cost;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
