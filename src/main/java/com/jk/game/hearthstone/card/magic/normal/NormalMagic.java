package com.jk.game.hearthstone.card.magic.normal;

import com.jk.game.hearthstone.card.magic.Magic;
import com.jk.game.hearthstone.card.magic.secret.Secret;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 常规法术
 *
 * @author jk
 */
public class NormalMagic extends Magic {

    private NormalMagic duplicate;

    public NormalMagic(Desktop desktop,int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }

    @Override
    public NormalMagic clone() throws CloneNotSupportedException {
        if(duplicate == null){
            duplicate = (NormalMagic) super.clone();
        }
        return duplicate;
    }

    /**
     * 法术效果
     * @param desktop 桌面环境
     * @param target 法术目标
     */
    public void effect(Desktop desktop, Organism target){

    }

}
