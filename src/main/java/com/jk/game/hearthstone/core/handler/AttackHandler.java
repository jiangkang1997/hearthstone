package com.jk.game.hearthstone.core.handler;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import org.springframework.util.StringUtils;

/**
 * @author ：lb
 * @date ：Created in 2020/8/2 0:42
 */
public class AttackHandler {

    /**
    * @Description: 单次攻击操作的实现
    * @Param: [desktop, card]
    * @return: void
    * @Author: lb
    * @Date: 2020/8/2
    */
    public static void  attack(Desktop desktop, Card card)throws IllegalOperationException {
        //棋盘参数预读取，玩家，奥秘，武器，任务（暂不考虑手牌费用）
        //根据触发条件，设置监听器，在事件触发时进行相应
        String i ="1" ;

        //判断是否可执行攻击操作
        if(StringUtils.isEmpty (i)){
            //攻击指令发出，攻击次数减1，监听器执行
            //进入事件处理器
            //doAttackEventProcessor(desktop,card)

            if(true){
                //事件处理完成，攻击未被取消
                //进行伤害结算
                //doAttackEventProcessor(desktop,card)
            }else if(true){
                //事件处理完成，攻击被取消
                //不知道有没有攻击执行失败触发的效果
                //进行数据更新，随从，玩家属性变更
                //doAttackEventProcessor(desktop,card)
            }
        }else {
            //本次攻击结束
            //log.error("无法进行攻击，请尝试其他操作");
        }
    }

    /**
    * @Description: 攻击准备的事件处理器
    * @Param: [desktop, card]
    * @return: void
    * @Author: lb
    * @Date: 2020/8/2
    */
    public static void doAttackStartProcessor(Desktop desktop, Card card)throws IllegalOperationException {
        //根据监听器来进行事件处理的判定
        //执行操作，返还结果
        //玩家生命降为0
        //随从被消灭
    }

    /**
     * @Description: 攻击结束的事件处理器
     * @Param: [desktop, card]
     * @return: void
     * @Author: lb
     * @Date: 2020/8/2
     */
    public static void doAttackOverProcessor(Desktop desktop, Card card)throws IllegalOperationException {
        //根据监听器来进行事件处理的判定
        //执行操作返还结果
        //玩家生命降为0
        //随从被消灭
    }
}
