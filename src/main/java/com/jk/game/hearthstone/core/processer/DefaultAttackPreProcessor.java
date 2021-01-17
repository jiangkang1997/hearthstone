package com.jk.game.hearthstone.core.processer;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.common.MinionCollection;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import org.springframework.util.CollectionUtils;

/**
 * 基础的攻击前置校验 只校验玩家指令 法术发出的攻击指令不适用此规则
 * @author jk
 * @date 2021/1/16 16:06
 */
public class DefaultAttackPreProcessor extends AbstractAttackPreProcessor {

    public DefaultAttackPreProcessor(Card owner) {
        super(owner);
    }

    @Override
    public void processBeforeHeroAttack(Desktop desktop, Organism source, Organism target) throws IllegalOperationException {
        //攻击力检查
        attackCheck(source);
        //可攻击检查
        attachableCheck(desktop, source, target);
        //立场检查 只能对敌方目标发起攻击
        standCheck(source, target);
        //免疫检查
        immuneCheck(target);
        //嘲讽检查
        ridiculeCheck(desktop, target);
    }

    private void attackCheck(Organism source) throws IllegalOperationException {
        if(source.getAttack() <= 0){
            throw new IllegalOperationException("无法攻击");
        }
    }

    private void attachableCheck(Desktop desktop, Organism source, Organism target) throws IllegalOperationException {
        String message = null;
        if(source.isCanAttack() && !source.isCanAttackHero() && target instanceof Hero){
            message = "这不是一个有效的目标";
        }
        if(!source.isCanAttack()){
            if(source.getAttackTime() >= 1){
                message = "已经攻击过了";
            }
            else if(source instanceof Minion && desktop.getHistory().getCurrentTurnNo()==((Minion)source).getBirthday()){
                message = "他需要一个回合进行准备";
            }
        }
        if(message != null){
            throw new IllegalOperationException(message);
        }
    }

    private void standCheck(Organism source, Organism target) throws IllegalOperationException {
        if(source.getPlayerType() == target.getPlayerType()){
            throw new IllegalOperationException("不可攻击己方目标");
        }
    }

    private void immuneCheck(Organism target) throws IllegalOperationException {
        if(target.isImmune()){
            throw new IllegalOperationException("这不是一个有效的目标");
        }
    }

    private void ridiculeCheck(Desktop desktop, Organism target) throws IllegalOperationException {
        if(target.isRidicule()){
            return;
        }
        MinionCollection minions = desktop.getMinions(target.getPlayerType());
        Hero hero = desktop.getPlayer(target.getPlayerType()).getHero();
        if(hero.isImmune()){
            //todo 冒险模式里面的馆长英雄有嘲讽 这里的报错提示可能有问题
            throw new IllegalOperationException("必须先攻击具有嘲讽的随从");
        }
        if(!CollectionUtils.isEmpty(minions.getList())){
            for (Minion minion : minions.getList()) {
                if(minion.isRidicule()){
                    throw new IllegalOperationException("必须先攻击具有嘲讽的随从");
                }
            }
        }
    }
}
