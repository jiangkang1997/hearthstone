package com.jk.game.hearthstone.card.magic;

import com.jk.hearthstone.card.biology.BaseBiology;
import com.jk.hearthstone.core.BaseController;
import com.jk.hearthstone.core.DefaultController;
import com.jk.hearthstone.data.Desktop;
import com.jk.hearthstone.data.History;

import static com.jk.hearthstone.enumeration.MagicType.MAGIC_TYPE_WITHTARGET;

public class 冰枪术 extends BaseMagic {

    public 冰枪术(){
        cost = 1;
        magicType = MAGIC_TYPE_WITHTARGET;
    }
    @Override
    public boolean effect(Desktop desktop, History history) {
        return false;
    }

    @Override
    public boolean effect(Desktop desktop, History history, BaseBiology target) {
        BaseController controller = new DefaultController();
        if(target.frozen){
            controller.hurt(desktop,history,target,4);
        }
        target.frozen = true;
        return true;
    }

    @Override
    public boolean combo(Desktop desktop, History history) {
        return false;
    }

    @Override
    public boolean combo(Desktop desktop, History history, BaseBiology target) {
        return effect(desktop,history,target);
    }
}
