package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.AuraType;
import com.jk.game.hearthstone.enumeration.Stand;

import javax.naming.directory.SearchResult;
import java.io.Serializable;
import java.rmi.ServerError;

/**
 * 光环
 * 炉石中所有的buff效果和光环统称为光环
 *
 * @author jk
 */
public interface Aura extends Serializable {

    /**
     * 获取光环类型
     * @return 光环类型
     */
    AuraType getAuraType();

    /**
     * 设置光环的发起者
     * @param owner 发起者
     */
    void setOwner(Card owner);

    /**
     * 获取光环的发起者
     * @return 光环的发起者
     */
    Card getOwner();

    /**
     * 获取光环已存活的回合数
     * @return 光环已存活的回合数
     */
    Integer getAge();

    /**
     * 光环的年龄 +1
     */
    void countAge();

    /**
     * 获取光环的持续时间
     * @return 光环的持续时间
     */
    AuraLife getAuraLife();

    /**
     * 获取光环作用的目标类型 （随从/英雄/所有）
     * @return 环作用的目标类型
     */
    Class<? extends Organism> getClassScope();

    /**
     * 获取光环作用的立场（友方/敌方/全部）
     * @return 光环作用的立场
     */
    Stand getStand();
}
