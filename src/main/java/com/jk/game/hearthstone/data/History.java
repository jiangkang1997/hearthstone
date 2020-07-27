package com.jk.game.hearthstone.data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏的历史纪录
 * @author jk
 */
@Data
public class History {
    public Turn currentTurn = new Turn();
    public Turn lastTurn = new Turn();

    public List<Turn> turnList = new ArrayList<>();
}
