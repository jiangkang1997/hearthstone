package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.data.AttackParameters;
import com.jk.game.hearthstone.data.AttackTarget;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.exception.AttackException;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;



/**
 * @author ：lb
 * @date ：Created in 2020/8/2 0:42
 */
@Slf4j
public class AttackHandler {

    protected static String message;

    //攻击
    public static void doAttack(Desktop desktop, AttackParameters attackParameters) throws AttackException, IllegalOperationException {
        //获取场面攻击者，被攻击对象
        //AttackTarget attackTarget = getAttackTarget (desktop);
        //AttackTarget attackTarget1 = new AttackTarget ();
        //AttackTarget attackTarget2 = new AttackTarget ();
        //
        //try {
        //    //判断单次攻击是否可行
        //    attackCheck (attackTarget, attackParameters);
        //} catch (Exception e) {
        //    log.error (message);
        //    e.printStackTrace ();
        //}
        //
        ////判断单次攻击是否可行
        //Player player1 = attackParameters.getMainPlayer ();
        //Player player2 = attackParameters.getSecondPlayer ();
        //Minion minion1 = attackParameters.getMainMinion ();
        //Minion minion2 = attackParameters.getSecondMinion ();
        //
        //int attackStatus = 0;
        //
        //if (player1 != null) {
        //    //英雄攻击英雄
        //    if (player2 != null) {
        //
        //        attackStatus = 1;
        //
        //        // 攻击前，事件触发，判断攻击是否继续
        //        Desktop desktop1 = doHeroAttackPreprocessor (desktop, attackParameters);
        //        attackTarget = getAttackTarget (desktop1);
        //        if (attackCheck (attackTarget, attackParameters)) {
        //            // 攻击继续
        //            int playerHeath = player2.getHero ().getArmor ()
        //                    + player2.getHero ().getHealth () - player1.getHero ().getAttack ();
        //            player2.getHero ().setHealth (playerHeath);
        //
        //            if (StringUtils.isEmpty (player1.getArms ()) && player1.getArms ().getDurable () > 1) {
        //                int duplicate = player1.getArms ().getDurable () - 1;
        //                player1.getArms ().setDurable (duplicate);
        //            }
        //            //desktop1.setMainPlayer (player1);
        //            //desktop1.setSecondPlayer (player2);
        //            //攻击后判断
        //            desktop1 = doHeroAttackPostprocessor (desktop1, attackParameters);
        //            // 进入结算
        //
        //            // 攻击取消
        //        } else {
        //
        //        }
        //
        //        //英雄攻击随从
        //    } else if (minion2 != null) {
        //
        //        attackStatus = 2;
        //
        //        // 攻击前，事件触发，判断攻击是否继续
        //        Desktop desktop1 = doHeroAttackPreprocessor (desktop, attackParameters);
        //        attackTarget = getAttackTarget (desktop1);
        //        if (attackCheck (attackTarget, attackParameters)) {
        //            // 攻击继续
        //            int playerHeath = player1.getHero ().getHealth () - minion2.getAttack ();
        //            player1.getHero ().setHealth (playerHeath);
        //            int minionHeath = minion2.getHealth () - player1.getHero ().getAttack ();
        //            if (minionHeath < 0) {
        //                minionHeath = 0;
        //            }
        //            minion2.setHealth (minionHeath);
        //
        //            //desktop1.setMainPlayer (player1);
        //
        //            //TODO 确定场面被攻击随从
        //            //for (Minion minion : desktop1.getSecondMinions ()) {
        //            //
        //            //}
        //
        //            // 攻击后判断
        //            desktop1 = doHeroAttackPostprocessor (desktop1, attackParameters);
        //            // 进入结算
        //
        //            // 攻击取消
        //        } else {
        //
        //        }
        //    }
        //}
        //
        ////随从攻击英雄
        //if (minion1 != null) {
        //    if (player2 != null) {
        //
        //        attackStatus = 3;
        //
        //        // 攻击前，事件触发，判断攻击是否继续
        //        Desktop desktop1 = doMinionAttackPreprocessor (desktop, attackParameters);
        //        attackTarget = getAttackTarget (desktop1);
        //        // 攻击前判断未终止的情况下
        //        if (attackCheck (attackTarget, attackParameters)) {
        //            int playerHeath = player2.getHero ().getArmor ()
        //                    + player2.getHero ().getHealth () - minion1.getAttack ();
        //            player2.getHero ().setHealth (playerHeath);
        //            //攻击后判断
        //            desktop1.setSecondPlayer (player2);
        //            doMinionAttackPostprocessor (desktop1, attackParameters);
        //            //TODO 进入结算
        //            //攻击取消
        //        } else {
        //
        //        }
        //        //随从攻击随从
        //    } else if (minion2 != null) {
        //
        //        attackStatus = 4;
        //
        //        // 攻击前，事件触发，判断攻击是否继续
        //        //Desktop desktop1 = doMinionAttackPreprocessor (desktop, attackParameters);
        //        //attackTarget = getAttackTarget (desktop1);
        //
        //        // 攻击前判断未终止的情况下
        //        if (attackCheck (attackTarget, attackParameters)) {
        //            int minionHeath = minion1.getHealth () - minion2.getAttack ();
        //            if (minionHeath < 0) {
        //                minionHeath = 0;
        //            }
        //            minion1.setHealth (minionHeath);
        //
        //            minionHeath = minion2.getHealth () - minion1.getAttack ();
        //            if (minionHeath < 0) {
        //                minionHeath = 0;
        //            }
        //            minion2.setHealth (minionHeath);
        //
        //            //TODO 确定场面被攻击随从
        //            //攻击后判断
        //            //doMinionAttackPostprocessor (desktop1, attackParameters);
        //            //TODO 进入结算
        //            //攻击取消
        //        } else {
        //
        //        }
        //    }
        //}

    }

    public static AttackTarget getAttackTarget(Desktop desktop) {
        AttackTarget attackTarget = new AttackTarget ();

        ////判断英雄是否能攻击
        //if (desktop.getMainPlayer () == null && desktop.getMainPlayer ().getHero ().getAttack () >= 0
        //        && desktop.getMainPlayer ().getHero ().getCanAttack ()) {
        //    attackTarget.setMainPlayer (desktop.getMainPlayer ());
        //}
        //
        ////找出能攻击的随从
        //List<Minion> mainMinions = desktop.getMainMinions ();
        //if (mainMinions != null && mainMinions.size () > 0) {
        //    for (Minion minion : mainMinions) {
        //        if (minion.getCanAttack () && minion.getAttack () > 0) {
        //            attackTarget.getMainMinions ().add (minion);
        //        }
        //    }
        //}
        //
        ////对手场上的随从
        //List<Minion> secondMinions = desktop.getSecondMinions ();
        //if (secondMinions != null && secondMinions.size () > 0) {
        //    for (Minion minion : secondMinions) {
        //        //对带有嘲讽的随从进行优先排列
        //        //排除沉睡的随从
        //        if (minion.getRidicule ()) {
        //            attackTarget.getRidiculeMinions ().add (minion);
        //        } else {
        //            attackTarget.getCommonlyMinions ().add (minion);
        //        }
        //    }
        //}

        return attackTarget;
    }

    public static boolean attackCheck(AttackTarget attackTarget, AttackParameters attackParameters) {
        Player player1 = attackParameters.getMainPlayer ();
        Player player2 = attackParameters.getSecondPlayer ();
        Minion minion1 = attackParameters.getMainMinion ();
        Minion minion2 = attackParameters.getSecondMinion ();


        if (player1 != null && player1 != attackTarget.getMainPlayer ()) {
            message = "玩家1异常";
        }

        if (player2 != null && player2 != attackTarget.getSecondPlayer ()) {
            message = "玩家2异常";
        } else if (attackTarget.getRidiculeMinions () != null && attackTarget.getRidiculeMinions ().size () > 0) {
            message = "必须先攻击有嘲讽的随从";
        }

        if (!attackTarget.getMainMinions ().contains (minion1)) {
            message = "未找到该随从";
        }

        if (!attackTarget.getCommonlyMinions ().contains (minion2)
                && !attackTarget.getRidiculeMinions ().contains (minion2)) {
            message = "未找到该随从";
        }

        if (minion2 != null
                && !attackTarget.getRidiculeMinions ().contains (minion2)) {
            message = "必须先攻击有嘲讽的随从";
        }

        if (StringUtils.isEmpty (message)) {
            return true;
        }
        return false;
    }

    //private static Desktop doHeroAttackPreprocessor(Desktop desktop, AttackParameters attackParameters) throws IllegalOperationException {
    //    //if(!StringUtils.isEmpty (status)){
        //    if(status ==1){
        //
        //    }else if(status == 2) {
        //
        //    }else if(status==3){
        //
        //    }else {
        //
        //    }
        //
        //
        //}


        //List<Processor> processors = desktop.getProcessorManager ().getProcessors (ProcessorType.PRE_HEROATTACK_SKILL);
        //for (Processor preprocessor : processors) {
        //    ((AbstractHeroAttackPreProcessor) preprocessor).processBeforeHeroAttack (desktop, attackParameters);
        //}
        //return desktop;
    //}


    //private static Desktop doMinionAttackPreprocessor(Desktop desktop, AttackParameters attackParameters) throws IllegalOperationException {
        //List<Processor> processors = desktop.getProcessorManager ().getProcessors (ProcessorType.PRE_MINIONATTACK_SKILL);
        //for (Processor preprocessor : processors) {
        //    ((AbstractMinionAttackPreProcessor) preprocessor).processBeforeMinionAttack (desktop, attackParameters);
        //}
        //return desktop;
    //}


    //private static Desktop doHeroAttackPostprocessor(Desktop desktop, AttackParameters attackParameters) throws IllegalOperationException {
        //List<Processor> processors = desktop.getProcessorManager ().getProcessors (ProcessorType.POST_HEROATTACK_SKILL);
        //for (Processor preprocessor : processors) {
        //    ((AbstractHeroAttackPostProcessor) preprocessor).processAfterHeroAttack (desktop, attackParameters);
        //}
        //return desktop;
    //}

    //private static Desktop doMinionAttackPostprocessor(Desktop desktop, AttackParameters attackParameters) throws IllegalOperationException {
        //List<Processor> processors = desktop.getProcessorManager ().getProcessors (ProcessorType.POST_MINIONATTACK_SKILL);
        //for (Processor preprocessor : processors) {
        //    ((AbstractMinionAttackPostProcessor) preprocessor).processAfterMinionAttack (desktop, attackParameters);
        //}
        //return desktop;
    //}
}
