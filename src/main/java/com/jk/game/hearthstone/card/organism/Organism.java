package com.jk.game.hearthstone.card.organism;


import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.core.aura.Aura;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.buff.Buff;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.BuffType;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Superclass of all organisms
 *
 * @author jk
 */
@Getter
@Setter
@NoArgsConstructor
public class Organism extends Card implements Cloneable {

    protected Integer attack = 0;
    protected Integer health = 0;
    protected List<Buff> buffList = new ArrayList<>();
    protected List<Aura> auraList = new ArrayList<>();

    public Organism(int cost, int attack, int health, String name, String desc, CardType cardType){
        super(cost, name, desc, cardType);
        this.attack = attack;
        this.health = health;
    }

    public int getAttack(){
        int result = attack;
        // 攻击力buff
        for (Buff buff : buffList) {
            if(buff.getBuffType() == BuffType.BUFF_TYPE_ATTACK){
                result += ((AbstractAttackBuff) buff).getAttackNum();
            }
        }
        //todo: 攻击力光环判断
        return result;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void registerBuff(Buff buff){
        buffList.add(buff);
    }

    public void registerAura(Aura aura){
        auraList.add(aura);
    }
}
