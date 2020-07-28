package com.jk.game.hearthstone.card;


import com.jk.game.hearthstone.enumeration.CardType;
import com.jk.game.hearthstone.enumeration.PlayerType;
import lombok.Data;

/**
 * Superclass of all cards
 *
 * @author jk
 */
@Data
public class Card implements Cloneable {

    protected Integer cost;
    protected Integer overload = 0;
    protected CardType cardType;
    protected PlayerType playerType;

    public Integer getCost(){
        //todo 需要完成减费效果和加费效果的结算
        return cost;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
