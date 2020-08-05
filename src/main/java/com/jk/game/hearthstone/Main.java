package com.jk.game.hearthstone;

import com.jk.game.hearthstone.card.Card;
import com.jk.game.hearthstone.card.Player;
import com.jk.game.hearthstone.card.classic.neutral.AbusiveSergeant;
import com.jk.game.hearthstone.card.classic.neutral.Wisp;
import com.jk.game.hearthstone.card.organism.hero.Hero;
import com.jk.game.hearthstone.core.handler.UseCardHandler;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * @author jk
 */
public class Main {

    public static void main(String[] args) throws IllegalOperationException {
        Desktop desktop = new Desktop();
        Player mainPlayer = new Player();
        Player secondPlayer = new Player();
        mainPlayer.setHero(new Hero());
        secondPlayer.setHero(new Hero());
        desktop.setMainPlayer(mainPlayer);
        desktop.setSecondPlayer(secondPlayer);
        mainPlayer.setPower(2);

        Wisp wisp = new Wisp();
        wisp.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        AbusiveSergeant abusiveSergeant = new AbusiveSergeant();
        abusiveSergeant.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);

        desktop.getMainCards().add(wisp);
        desktop.getMainCards().add(abusiveSergeant);

        UseCardHandler.usrCard(desktop,wisp,null);
        UseCardHandler.usrCard(desktop,abusiveSergeant,wisp);
    }
}
