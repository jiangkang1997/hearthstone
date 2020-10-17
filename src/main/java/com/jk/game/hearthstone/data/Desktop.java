package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.magic.Magic;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.aura.AuraManager;
import com.jk.game.hearthstone.core.processer.ProcessorManager;
import com.jk.game.hearthstone.enumeration.PlayerType;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 游戏桌面，包括所有的手牌，在场随从及环境参数
 *
 * @author jk
 */
@Data
public class Desktop implements Serializable {

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

    /**
     * 光环管理器
     */
    private AuraManager auraManager = new AuraManager();

    /**
     * 历史记录
     */
    private History history;

    /**
     * 副本
     */
    private Desktop duplicate;

    /**
     * 法强
     */
    private int mainSpellPower = 0;
    private int secondSpellPower = 0;

    @Override
    public Desktop clone() throws CloneNotSupportedException {
        if (duplicate == null) {
            duplicate = (Desktop) super.clone();
            duplicate.mainMinions = new ArrayList<>();
            duplicate.secondMinions = new ArrayList<>();
            duplicate.mainCards = new ArrayList<>();
            duplicate.secondMinions = new ArrayList<>();
            duplicate.mainTasksAndSecrets = new ArrayList<>();
            duplicate.secondTasksAndSecrets = new ArrayList<>();
            if (mainPlayer != null) {
                duplicate.mainPlayer = mainPlayer.clone();
            }
            if (secondPlayer != null) {
                duplicate.secondPlayer = secondPlayer.clone();
            }
            for (Minion minion : mainMinions) {
                duplicate.mainMinions.add(minion.clone());
            }
            for (Minion minion : secondMinions) {
                duplicate.secondMinions.add(minion.clone());
            }
            for (Card card : mainCards) {
                duplicate.mainCards.add(card.clone());
            }
            for (Card card : secondCards) {
                duplicate.secondCards.add(card.clone());
            }
            for (Magic tasksAndSecret : mainTasksAndSecrets) {
                duplicate.mainTasksAndSecrets.add(tasksAndSecret.clone());
            }
            for (Magic tasksAndSecret : secondTasksAndSecrets) {
                duplicate.secondTasksAndSecrets.add(tasksAndSecret.clone());
            }
            duplicate.processorManager = processorManager.clone();
            //todo : 光环clone

        }
        return duplicate;
    }

    public Player getPlayer(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainPlayer : secondPlayer;
    }

    public List<Card> getCards(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainCards : secondCards;
    }

    public List<Minion> getMinions(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainMinions : secondMinions;
    }

    public List<Magic> getTasksAndSecrets(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainTasksAndSecrets : secondTasksAndSecrets;
    }

    public int getSpellPower(PlayerType playerType){
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainSpellPower : secondSpellPower;
    }

}
