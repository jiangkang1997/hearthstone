package com.jk.game.hearthstone.data;


import com.jk.game.hearthstone.card.BaseCard;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.organism.entourage.BaseEntourage;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏桌面，包括所有的手牌，在场随从及环境参数
 * @author jk
 */
@Data
public class Desktop implements Cloneable {

    private Player enemy;
    private Player myself;
    private List<BaseEntourage> enemiesEntourage = new ArrayList<>();
    private List<BaseEntourage> myEntourage = new ArrayList<>();
    private List<BaseCard> myCards = new ArrayList<>();
    private List<BaseCard> enemiesCards = new ArrayList<>();

    @Override
    public Object clone() throws CloneNotSupportedException {
        Desktop result = (Desktop)super.clone();
        if(enemy!=null){
            result.enemy = (Player) enemy.clone();
        }
        if(myself!=null){
            result.myself = (Player) myself.clone();
        }
        for (BaseEntourage entourage : enemiesEntourage) {
            result.enemiesEntourage.add((BaseEntourage) entourage.clone());
        }
        for (BaseEntourage entourage : myEntourage) {
            result.myEntourage.add((BaseEntourage) entourage.clone());
        }
        for (BaseCard card : myCards) {
            result.myCards.add((BaseCard) card.clone());
        }
        for (BaseCard card : enemiesCards) {
            result.enemiesCards.add((BaseCard) card.clone());
        }
        return result;
    }
}
