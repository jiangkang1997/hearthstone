package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.data.AttackParameters;
import com.jk.game.hearthstone.data.AttackTarget;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.exception.AttackException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author ：lb
 * @date ：Created in 2020/8/2 0:42
 */
@Slf4j
public class AttackHandler {

    protected  static String message;

    private static boolean attackCheck( AttackTarget attackTarget,AttackParameters attackParameters){
        Player player1 = attackParameters.getMainPlayer ();
        Player player2 = attackParameters.getSecondPlayer ();
        Minion minion1 = attackParameters.getMainMinion ();
        Minion minion2 = attackParameters.getSecondMinion ();


        if(player1!= null && player1 != attackTarget.getMainPlayer ()){
            message ="玩家1异常";
        }

        if(player2!= null && player2 != attackTarget.getSecondPlayer ()){
            message ="玩家2异常";
        }else if(attackTarget.getRidiculeMinions ()!=null && attackTarget.getRidiculeMinions ().size ()>0){
            message = "必须先攻击有嘲讽的随从";
        }

        if(!attackTarget.getMainMinions ().contains (minion1)){
            message ="未找到该随从";
        }

        if(!attackTarget.getCommonlyMinions ().contains (minion2)
                && !attackTarget.getRidiculeMinions ().contains (minion2)){
            message ="未找到该随从";
        }

        if(minion2!=null
                && !attackTarget.getRidiculeMinions ().contains (minion2)){
            message = "必须先攻击有嘲讽的随从";
        }

        if(StringUtils.isEmpty (message)){
            return true;
        }
        return false;
    }

    //攻击
    public static void doAttack(Desktop desktop , AttackParameters attackParameters) throws AttackException{
        AttackTarget attackTarget = getAttackTarget (desktop);

        try {
            attackCheck(attackTarget,attackParameters);
        }catch (Exception e){
            log.error (message);
            e.printStackTrace ();
        }


        Player player1 = attackParameters.getMainPlayer ();
        Player player2 = attackParameters.getSecondPlayer ();
        Minion minion1 = attackParameters.getMainMinion ();
        Minion minion2 = attackParameters.getSecondMinion ();

        if(player1!= null) {
            if (player2 != null) {
                //TODO 攻击前判断
                int playerHeath = player2.getHero ().getArmor ()
                        + player2.getHero ().getHealth () - player1.getHero ().getAttack ();
                player2.getHero ().setHealth (playerHeath);

                if (StringUtils.isEmpty (player1.getArms ()) && player1.getArms ().getDurable () > 1) {
                    int duplicate = player1.getArms ().getDurable () - 1;
                    player1.getArms ().setDurable (duplicate);
                }
                //TODO 攻击后判断，进入结算

            } else if (minion2 != null) {
                //TODO 攻击前判断
                int playerHeath = player1.getHero ().getHealth () - minion2.getAttack ();
                player1.getHero ().setHealth (playerHeath);
                int minionHeath = minion2.getHealth () - player1.getHero ().getAttack ();
                if (minionHeath < 0) {
                    minionHeath = 0;
                }
                minion2.setHealth (minionHeath);
                //TODO 攻击后判断，进入结算
            }
        }

        if(minion1!= null){
                if(player2 != null){
                    //TODO 攻击前判断
                    int playerHeath =  player2.getHero ().getArmor()
                            + player2.getHero ().getHealth () - minion1.getAttack ();
                    player2.getHero ().setHealth (playerHeath);
                    //TODO 攻击后判断，进入结算

                }else if(minion2 != null){
                    //TODO 攻击前判断

                    int minionHeath =  minion1.getHealth () - minion2.getAttack ();
                    if(minionHeath < 0){
                        minionHeath = 0;
                    }
                    minion1.setHealth (minionHeath);

                     minionHeath = minion2.getHealth () - minion1.getAttack ();
                    if(minionHeath < 0){
                        minionHeath = 0;
                    }
                    minion2.setHealth (minionHeath);

                    //TODO 攻击后判断，进入结算
                }
        }

    }

    public static AttackTarget getAttackTarget(Desktop desktop){
        AttackTarget attackTarget = new AttackTarget ();

        //判断英雄是否能攻击
        if(desktop.getMainPlayer () == null && desktop.getMainPlayer().getHero ().getAttack ()>=0
                && desktop.getMainPlayer().getHero ().getCanAttack ()){
            attackTarget.setMainPlayer (desktop.getMainPlayer ());
        }

        //找出能攻击的随从
        List<Minion> mainMinions = desktop.getMainMinions ();
        if(mainMinions != null && mainMinions.size ()>0 ){
            for(Minion minion:mainMinions){
                if(minion.getCanAttack () && minion.getAttack ()>0){
                    attackTarget.getMainMinions ().add (minion);
                }
            }
        }

        //对手场上的随从
        List<Minion> secondMinions = desktop.getSecondMinions ();
        if(secondMinions!=null && secondMinions.size ()>0){
            for(Minion minion:secondMinions){
                //对带有嘲讽的随从进行优先排列
                //排除沉睡的随从
                if(minion.getRidicule ()){
                    attackTarget.getRidiculeMinions ().add (minion);
                } else {
                    attackTarget.getCommonlyMinions ().add (minion);
                }
            }
        }

        return attackTarget;
    }
}
