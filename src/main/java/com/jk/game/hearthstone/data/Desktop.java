package com.jk.game.hearthstone.data;


import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.magic.Magic;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import com.jk.game.hearthstone.core.processer.ProcessorManager;
import com.jk.game.hearthstone.enumeration.PlayerType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏桌面，包括所有的手牌，在场随从及环境参数
 * @author jk
 */
@Data
public class Desktop implements Cloneable {

    /**
     * 玩家
     */
    private Player mainPlayer;
    private Player secondPlayer;

    /**
     * 场上随从
     */
    private List<Minion> mainMinions = new ArrayList<>();
    private List<Minion> secondMinions = new ArrayList<>();

    /**
     * 手牌
     */
    private List<Card> mainCards = new ArrayList<>();
    private List<Card> secondCards = new ArrayList<>();

    /**
     * 头上的任务和奥秘
     */
    private List<Magic> mainTasksAndSecrets = new ArrayList<>();
    private List<Magic> secondTasksAndSecrets = new ArrayList<>();

    /**
     * 事件处理器管理者
     */
    private ProcessorManager processorManager = new ProcessorManager();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Desktop result = (Desktop)super.clone();
        if(secondPlayer!=null){
            result.secondPlayer = (Player) secondPlayer.clone();
        }
        if(mainPlayer!=null){
            result.mainPlayer = (Player) mainPlayer.clone();
        }
        for (Minion minion : secondMinions) {
            result.secondMinions.add((Minion) minion.clone());
        }
        for (Minion minion : mainMinions) {
            result.mainMinions.add((Minion) minion.clone());
        }
        for (Card card : mainCards) {
            result.mainCards.add((Card) card.clone());
        }
        for (Card card : secondCards) {
            result.secondCards.add((Card) card.clone());
        }
        return result;
    }

    public Player getPlayer(PlayerType playerType){
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainPlayer : secondPlayer;
    }

    public List<Card> getCards(PlayerType playerType){
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainCards : secondCards;
    }

    public List<Minion> getMinions(PlayerType playerType){
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainMinions : secondMinions;
    }

    public List<Magic> getTasksAndSecrets(PlayerType playerType){
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainTasksAndSecrets : secondTasksAndSecrets;
    }
}
