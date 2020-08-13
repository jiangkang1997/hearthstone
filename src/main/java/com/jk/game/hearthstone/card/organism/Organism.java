package com.jk.game.hearthstone.card.organism;


import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.buff.Buff;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.BuffType;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

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
public class Organism extends Card{

    protected Integer attack = 0;
    protected Integer health = 0;
    protected boolean canAttack = false;
    protected List<Buff> buffList = new ArrayList<>();

    private Organism duplicate;

    public Organism(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType){
        super(desktop,cost, name, desc, cardType);
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
    public Organism clone() throws CloneNotSupportedException {
        if(duplicate == null){
            Organism result = (Organism) super.clone();
            duplicate = result;
            if(!CollectionUtils.isEmpty(buffList)){
                List<Buff> buffListClone = new ArrayList<>();
                for (Buff buff : buffList) {
                    buffListClone.add(buff.clone());
                }
                result.setBuffList(buffListClone);
            }
        }
        return duplicate;
    }

    public void registerBuff(Buff buff){
        buffList.add(buff);
    }


    public boolean getCanAttack(){
        //todo：能否攻击的基本逻辑 包括冲锋，突袭，冰冻等
        return canAttack;
    }
}
