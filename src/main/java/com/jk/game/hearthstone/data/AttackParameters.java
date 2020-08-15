package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import lombok.Data;

/**
 * @author ：lb
 * @date ：Created in 2020/8/15 21:25
 */

@Data
public class AttackParameters {

    /**
     * 玩家
     */
    private Player mainPlayer;
    private Player secondPlayer;

    /**
     * 场上随从
     */
    private Minion mainMinion;
    private Minion secondMinion;

}
