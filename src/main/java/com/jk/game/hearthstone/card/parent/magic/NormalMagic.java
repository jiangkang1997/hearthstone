package com.jk.game.hearthstone.card.parent.magic;

import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.CardType;

/**
 * 常规法术
 *
 * @author jk
 */
public class NormalMagic extends Magic {

    public NormalMagic(Desktop desktop,int cost, String name, String desc, CardType cardType){
        super(desktop, cost, name, desc, cardType);
    }


    /**
     * 法术效果
     * @param desktop 桌面环境
     * @param target 法术目标
     */
    public void effect(Desktop desktop, Organism target){

    }

}
