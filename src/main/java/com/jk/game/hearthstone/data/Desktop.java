package com.jk.game.hearthstone.data;


import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.organism.minion.Minion;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏桌面，包括所有的手牌，在场随从及环境参数
 * @author jk
 */
@Data
public class Desktop implements Cloneable {

    private Player mainPlayer;
    private Player secondPlayer;
    private List<Minion> mainMinions = new ArrayList<>();
    private List<Minion> secondMinions = new ArrayList<>();
    private List<Card> mainCards = new ArrayList<>();
    private List<Card> secondCards = new ArrayList<>();

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
}
