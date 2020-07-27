package com.jk.game.hearthstone.card.magic;

import com.jk.hearthstone.card.biology.BaseBiology;
import com.jk.hearthstone.card.biology.entourage.BaseEntourage;
import com.jk.hearthstone.data.Desktop;
import com.jk.hearthstone.data.History;

import static com.jk.hearthstone.enumeration.MagicType.MAGIC_TYPE_WITHTARGET;

public class 冷血 extends BaseMagic {

    public 冷血(){
        cost = 2;
        magicType = MAGIC_TYPE_WITHTARGET;
    }

    @Override
    public boolean effect(Desktop desktop, History history) {
        return false;
    }

    @Override
    public boolean effect(Desktop desktop, History history, BaseBiology target) {
        if(!(target instanceof BaseEntourage)){
            return false;
        }
        ((BaseEntourage) target).att += 2;
        return true;
    }

    @Override
    public boolean combo(Desktop desktop, History history) {
        return false;
    }

    @Override
    public boolean combo(Desktop desktop, History history, BaseBiology target) {
        if(!(target instanceof BaseEntourage)){
            return false;
        }
        ((BaseEntourage) target).att += 4;
        return true;
    }
}
