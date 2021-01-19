package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.parent.Card;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.magic.Magic;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.common.CardCollection;
import com.jk.game.hearthstone.common.MinionCollection;
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
    private MinionCollection mainMinions = new MinionCollection(PlayerType.PLAYER_TYPE_MAIN);
    private MinionCollection secondMinions = new MinionCollection(PlayerType.PLAYER_TYPE_SECOND);

    /**
     * 手牌
     */
    private CardCollection mainCards = new CardCollection(PlayerType.PLAYER_TYPE_MAIN);
    private CardCollection secondCards = new CardCollection(PlayerType.PLAYER_TYPE_SECOND);

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
    private History history = new History();

    /**
     * 法强
     */
    private int mainSpellPower = 0;
    private int secondSpellPower = 0;

    public Player getPlayer(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainPlayer : secondPlayer;
    }

    public CardCollection getCards(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainCards : secondCards;
    }

    public MinionCollection getMinions(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainMinions : secondMinions;
    }

    public List<Magic> getTasksAndSecrets(PlayerType playerType) {
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainTasksAndSecrets : secondTasksAndSecrets;
    }

    public int getSpellPower(PlayerType playerType){
        return playerType == PlayerType.PLAYER_TYPE_MAIN ? mainSpellPower : secondSpellPower;
    }

}
