package com.jk.game.hearthstone.card.parent.organism;

import com.jk.game.hearthstone.annotation.CurrentTurn;
import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.core.aura.AbstractAttackAura;
import com.jk.game.hearthstone.core.aura.Aura;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.buff.Buff;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.AuraType;
import com.jk.game.hearthstone.enumeration.BuffType;
import com.jk.game.hearthstone.enumeration.CardType;
import lombok.Getter;
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
public class Organism extends Card{

    protected int attack = 0;
    protected int health = 0;
    /**
     * 血量上限
     */
    protected int maxHealth = 0;
    protected boolean canAttack = false;
    protected boolean canAttackHero = true;
    /**
     * 嘲讽
     */
    protected boolean ridicule = false;
    /**
     * 冻结
     */
    protected boolean freeze = false;
    /**
     * 风怒
     */
    protected boolean windfury = false;
    /**
     * 免疫
     */
    protected boolean immune = false;
    /**
     * 寿命，死亡结算的结算依据，负数代表存活
     * 战斗死亡和剧毒会直接标记为0，腐化迷雾和力量代价等标记为剩余寿命
     */
    @CurrentTurn
    protected int life = -1;
    /**
     * 当前回合已攻击的数量
     */
    @CurrentTurn
    protected int attackTime = 0;

    protected List<Buff> buffList = new ArrayList<>();

    public Organism(Desktop desktop,int cost, int attack, int health, String name, String desc, CardType cardType){
        super(desktop,cost, name, desc, cardType);
        this.attack = attack;
        this.health = health;
        this.maxHealth = health;
    }

    public int getAttack(){
        int result = attack;
        // 攻击力buff
        for (Buff buff : buffList) {
            if(buff.getBuffType() == BuffType.BUFF_TYPE_ATTACK){
                result += ((AbstractAttackBuff) buff).getAttackNum();
            }
        }
        //攻击力光环
        List<Aura> attackAuras = desktop.getAuraManager().getAurasByType(AuraType.AURA_TYPE_ATTACK);
        if (!CollectionUtils.isEmpty(attackAuras)) {
            for (Aura attackAura : attackAuras) {
                if(attackAura.judge(this)){
                    result += ((AbstractAttackAura) attackAura).getNum();
                }
            }
        }
        return result;
    }


    public void registerBuff(Buff buff){
        buffList.add(buff);
    }

    public boolean isRidicule() {
        for (Buff buff : buffList) {
            if(buff.getBuffType() == BuffType.BUFF_TYPE_RIDICULE){
                return !ridicule;
            }
        }
        return ridicule;
    }
}
