package com.jk.game.hearthstone.card.arms;


import com.jk.game.hearthstone.annotation.BloodSucking;
import com.jk.game.hearthstone.enumeration.CardOwner;

/**
 * @author jk
 */
@BloodSucking
public class 邪恶短刀 extends BaseArms {

    public 邪恶短刀(){
        att = 1;
        durable = 2;
        cost = 2;
        cardOwner = CardOwner.CARD_OWNER_潜行者;
    }
}
