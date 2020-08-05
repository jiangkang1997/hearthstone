package com.jk.game.hearthstone.core.aura;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.organism.Organism;
import com.jk.game.hearthstone.enumeration.AuraLife;
import com.jk.game.hearthstone.enumeration.AuraType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 光环的管理者
 * 游戏中所有的光环在这里统一注册和卸载
 * 并提供统一的光环查找方法
 *
 * @author jk
 */
public class AuraManager {

    private Map<AuraType, List<Aura>> registerAuraMap = new HashMap<>();

    /**
     * 注册光环
     * @param aura 光环
     */
    public void register(Aura aura){
        AuraType auraType = aura.getAuraType();
        if(registerAuraMap.get(auraType) == null){
            List<Aura> auras = new ArrayList<>();
            auras.add(aura);
            registerAuraMap.put(auraType,auras);
        }else {
            registerAuraMap.get(auraType).add(aura);
        }
    }

    /**
     * 移除过期的光环
     */
    public void removeExpiredAura(){
        for (List<Aura> auras : registerAuraMap.values()) {
            List<Aura> remove = new ArrayList<>();
            for (Aura aura : auras) {
                if(aura.getAuraLife() == AuraLife.AURA_LIFE_ONE_TURN && aura.getAge()>=1){
                    remove.add(aura);
                }else if(aura.getAuraLife() == AuraLife.AURA_LIFE_TWO_TURN && aura.getAge()>=2){
                    remove.add(aura);
                }
            }
            auras.removeAll(remove);
        }
    }

    /**
     * 移除依赖于某个卡片的光环
     * @param owner 被依赖的卡片
     */
    public void removeDependAura(Card owner){
        for (List<Aura> auras : registerAuraMap.values()) {
            List<Aura> remove = new ArrayList<>();
            for (Aura aura : auras) {
                if(aura.getOwner() == owner && aura.getAuraLife() == AuraLife.AURA_LIFE_DEPEND){
                    remove.add(aura);
                }
            }
            auras.removeAll(remove);
        }
    }

    /**
     * 获取某种类型的光环
     * @param auraType 光环类型
     * @return 已注册的这种类型的所有光环
     */
    public List<Aura> getAurasByType(AuraType auraType){
        return registerAuraMap.get(auraType);
    }

    /**
     * 查询某生物被附加的所有的指定类型的光环
     * @param auraType 光环类型
     * @param target 被附加的目标
     * @return 光环
     */
    /*public List<Aura> getAuraByTypeAndTarget(AuraType auraType, Organism target){
        List<Aura> result = new ArrayList<>();
        List<Aura> auras = registerAuraMap.get(auraType);
        for (Aura aura : auras) {
            //if(aura)
        }

    }*/
}
