package com.jk.game.hearthstone.card.magic;

import com.jk.hearthstone.card.BaseCard;
import com.jk.hearthstone.card.biology.BaseBiology;
import com.jk.hearthstone.data.Desktop;
import com.jk.hearthstone.data.History;
import com.jk.hearthstone.enumeration.MagicType;

/**
 * 所有的法术牌的基类
 * @author jk
 */
public abstract class BaseMagic extends BaseCard {
    public MagicType magicType;

    /**
     * 法术效果
     */
    public abstract boolean effect(Desktop desktop, History history);

    /**
     * 需要选择目标的法术效果
     * @param target 选择的目标
     */
    public abstract boolean effect(Desktop desktop,History history,BaseBiology target);


    /**
     * 连击效果
     * @param desktop 桌面环境
     * @param history 游戏历史
     */
    public abstract boolean combo(Desktop desktop, History history);

    /**
     * 要选择目标的连击效果
     * @param desktop
     * @param history
     * @param target 选择的目标
     */
    public abstract boolean combo(Desktop desktop, History history,BaseBiology target);
}
