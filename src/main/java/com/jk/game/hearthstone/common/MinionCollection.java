package com.jk.game.hearthstone.common;

import com.jk.game.hearthstone.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.enumeration.PlayerType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @date 2021/1/4 22:57
 */
public class MinionCollection implements Serializable {

    private final List<Minion> list = new ArrayList<>();

    private final PlayerType playerType;

    private static final int MAX_MINION_NUM = 7;

    public MinionCollection(PlayerType playerType){
        this.playerType = playerType;
    }

    public void add(Minion minion){
        if(list.size() < MAX_MINION_NUM){
            minion.setPlayerType(playerType);
            list.add(minion);
        }
    }

    public void remove(Minion minion){
        list.remove(minion);
    }

    public List<Minion> getList() {
        return list;
    }
}
