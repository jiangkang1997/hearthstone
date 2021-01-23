package com.jk.game.hearthstone.core.card.parent.arms;

import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.buff.Buff;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.BuffType;
import com.jk.game.hearthstone.core.enumeration.CardType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Superclass of all arms
 * @author jk
 */

@Getter
@Setter
public class Arms extends Card{

    /**
     * 攻击力
     */
    protected Integer attack;
    /**
     * 耐久
     */
    protected Integer durable;
    /**
     * 吸血
     */
    protected boolean bloodSucking;

    protected final List<Buff> buffList = new ArrayList<>();

    public Arms(Desktop desktop, int cost,int attack,int durable, String name, String desc, CardType cardType) {
        super(desktop, cost, name, desc, cardType);
        this.attack = attack;
        this.durable = durable;
    }

    public int getAttack(){
        int result = attack;
        //攻击力buff
        if(!CollectionUtils.isEmpty(buffList)){
            for (Buff buff : buffList) {
                if(buff.getBuffType() == BuffType.BUFF_TYPE_ATTACK){
                    result += ((AbstractAttackBuff) buff).getAttackNum();
                }
            }
        }
        //todo：攻击力光环
        return result;
    }

    public void registerBuff(Buff buff){
        if(buff != null){
            buffList.add(buff);
        }
    }
}
