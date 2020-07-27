package com.jk.game.hearthstone.card.magic;

import com.jk.hearthstone.card.biology.BaseBiology;
import com.jk.hearthstone.core.Controller;
import com.jk.hearthstone.data.Desktop;
import com.jk.hearthstone.data.History;

import static com.jk.hearthstone.enumeration.MagicType.MAGIC_TYPE_WITHTARGET;

public class 寒冰箭 extends BaseMagic {

    public 寒冰箭(){
        cost = 2;
        magicType = MAGIC_TYPE_WITHTARGET;
    }

    @Override
    public boolean effect(Desktop desktop, History history) {
        return false;
    }

    @Override
    public boolean effect(Desktop desktop, History history, BaseBiology target) {
        Controller controller = new Controller(desktop,history);
        controller.hurt(target,3);
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
