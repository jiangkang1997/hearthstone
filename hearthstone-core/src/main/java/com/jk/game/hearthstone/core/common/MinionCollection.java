package com.jk.game.hearthstone.core.common;

import com.jk.game.hearthstone.core.card.parent.organism.minion.Minion;
import com.jk.game.hearthstone.core.enumeration.PlayerType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
            //默认放在最右边
            list.add(minion);
        }
    }

    public void add(Minion minion,Integer seat){
        if(list.size() < MAX_MINION_NUM){
            minion.setPlayerType(playerType);
            if(seat == null){
                //默认放在最右边
                list.add(minion);
            }
            else {
                if(seat<0){
                    seat = 0;
                }else if(seat > list.size()){
                    seat = list.size();
                }
                list.add(seat,minion);
            }
        }
    }

    public void remove(Minion minion){
        list.remove(minion);
    }

    public boolean contains(Object o){
        return list.contains(o);
    }

    public int getIndex(Object o){
        if(contains(o)){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == o){
                    return i;
                }
            }
        }
        return -1;
    }

    @Deprecated
    public List<Minion> getList() {
        return list;
    }

    public Iterator<Minion> iterator(){
        return list.iterator();
    }
}
