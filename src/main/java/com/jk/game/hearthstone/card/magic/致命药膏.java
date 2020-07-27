package com.jk.game.hearthstone.card.magic;

import com.jk.hearthstone.card.biology.BaseBiology;
import com.jk.hearthstone.data.Desktop;
import com.jk.hearthstone.data.History;

import static com.jk.hearthstone.enumeration.MagicType.MAGIC_TYPE_WITHOUTTARGET;

public class 致命药膏 extends BaseMagic {

    public 致命药膏(){
        cost = 1;
        magicType = MAGIC_TYPE_WITHOUTTARGET;
    }

    @Override
    public boolean effect(Desktop desktop, History history) {
        if(desktop.myself.arms==null){
            return false;
        }
        desktop.myself.arms.att += 2;
        return true;
    }

    @Override
    public boolean effect(Desktop desktop, History history, BaseBiology target) {
        return false;
    }

    @Override
    public boolean combo(Desktop desktop, History history) {
        return effect(desktop,history);
    }

    @Override
    public boolean combo(Desktop desktop, History history, BaseBiology target) {
        return false;
    }
}
