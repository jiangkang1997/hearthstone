package com.jk.game.hearthstone;

import com.jk.game.hearthstone.card.classic.mage.FrostArrow;
import com.jk.game.hearthstone.card.classic.mage.IceSpear;
import com.jk.game.hearthstone.card.classic.mage.ManaDragon;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.classic.neutral.AbusiveSergeant;
import com.jk.game.hearthstone.card.classic.neutral.Wisp;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.core.handler.UseCardHandler;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;

/**
 * @author jk
 */
public class Main {

    public static void main(String[] args) throws IllegalOperationException, CloneNotSupportedException {
        Desktop desktop = new Desktop();
        Player mainPlayer = new Player();
        Player secondPlayer = new Player();
        mainPlayer.setHero(new Hero(desktop,"敌人",PlayerType.PLAYER_TYPE_MAIN));
        secondPlayer.setHero(new Hero(desktop,"玩家",PlayerType.PLAYER_TYPE_SECOND));
        desktop.setMainPlayer(mainPlayer);
        desktop.setSecondPlayer(secondPlayer);
        mainPlayer.setPower(10);

        Wisp wisp = new Wisp(desktop);
        wisp.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        AbusiveSergeant abusiveSergeant = new AbusiveSergeant(desktop);
        abusiveSergeant.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);

        FrostArrow frostArrow = new FrostArrow(desktop);
        IceSpear iceSpear  = new IceSpear(desktop);
        ManaDragon manaDragon = new ManaDragon(desktop);
        frostArrow.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        iceSpear.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        manaDragon.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);

        desktop.getMainCards().add(wisp);
        desktop.getMainCards().add(abusiveSergeant);

        UseCardHandler.usrCard(desktop,manaDragon,null);
        UseCardHandler.usrCard(desktop,wisp,null);
        UseCardHandler.usrCard(desktop,abusiveSergeant,wisp);
        UseCardHandler.usrCard(desktop,frostArrow,secondPlayer.getHero());
        UseCardHandler.usrCard(desktop,iceSpear,secondPlayer.getHero());

        System.out.println(wisp.getAttack());
        System.out.println(secondPlayer.getHero().getHealth());
        System.out.println(manaDragon.getAttack());
    }
}
