package com.jk.game.hearthstone.data;

import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lb
 * @date ：Created in 2020/8/15 21:25
 */

@Data
public class AttackTarget implements Serializable {

    /**
     * 玩家
     */
    private Player mainPlayer;
    private Player secondPlayer;

    /**
     * 场上随从
     */
    private List<Minion> mainMinions = new ArrayList<> ();
    private List<Minion> ridiculeMinions = new ArrayList<>();
    private List<Minion> commonlyMinions = new ArrayList<>();

}
