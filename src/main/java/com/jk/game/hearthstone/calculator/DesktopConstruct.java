package com.jk.game.hearthstone.calculator;

import com.jk.game.hearthstone.card.base.*;
import com.jk.game.hearthstone.card.base.shaman.Windfury;
import com.jk.game.hearthstone.card.classic.mage.FrostArrow;
import com.jk.game.hearthstone.card.classic.mage.IceSpear;
import com.jk.game.hearthstone.card.classic.mage.ManaDragon;
import com.jk.game.hearthstone.card.classic.neutral.AbusiveSergeant;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.parent.organism.hero.Rouge;
import com.jk.game.hearthstone.core.handler.JoinHandler;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.InvalidOperationException;

/**
 * @author jk
 * @date 2021/1/12 21:34
 */
public class DesktopConstruct {

    public static Desktop desktop1_1() throws InstantiationException, IllegalAccessException, InvalidOperationException {
        Desktop desktop = new Desktop();

        Player mainPlayer = new Player();
        Hero mainHero = new Rouge(desktop, PlayerType.PLAYER_TYPE_MAIN);
        mainPlayer.setHero(mainHero);
        desktop.setMainPlayer(mainPlayer);

        Player secondPlayer = new Player();
        Hero secondHero = new Hero(desktop, "敌人",null, PlayerType.PLAYER_TYPE_SECOND);
        secondPlayer.setHero(secondHero);
        desktop.setSecondPlayer(secondPlayer);

        secondHero.setHealth(9);
        mainPlayer.setPower(5);
        mainPlayer.setMaxPower(5);

        ColdBlooded coldBlooded = new ColdBlooded(desktop);
        DeathlyPoison deathlyPoison = new DeathlyPoison(desktop);
        desktop.getMainCards().add(coldBlooded);
        desktop.getMainCards().add(deathlyPoison);

        BluegillWarrior bluegillWarrior = new BluegillWarrior(desktop);
        bluegillWarrior.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        JoinHandler.join(desktop,bluegillWarrior);

        return desktop;
    }

    public static Desktop desktop1_2() throws InstantiationException, IllegalAccessException, InvalidOperationException {
        Desktop desktop = new Desktop();

        Player mainPlayer = new Player();
        Hero mainHero = new Rouge(desktop, PlayerType.PLAYER_TYPE_MAIN);
        mainPlayer.setHero(mainHero);
        desktop.setMainPlayer(mainPlayer);

        Player secondPlayer = new Player();
        Hero secondHero = new Hero(desktop, "敌人",null, PlayerType.PLAYER_TYPE_SECOND);
        secondPlayer.setHero(secondHero);
        desktop.setSecondPlayer(secondPlayer);

        secondHero.setHealth(10);
        mainPlayer.setPower(4);
        mainPlayer.setMaxPower(4);

        //手牌 两张寒冰箭 一张冰枪术
        FrostArrow frostArrow1 = new FrostArrow(desktop);
        FrostArrow frostArrow2 = new FrostArrow(desktop);
        IceSpear iceSpear = new IceSpear(desktop);
        frostArrow1.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        frostArrow2.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        iceSpear.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        desktop.getMainCards().add(frostArrow1);
        desktop.getMainCards().add(frostArrow2);
        desktop.getMainCards().add(iceSpear);

        //场上一张可攻击的法力伏龙
        ManaDragon manaDragon = new ManaDragon(desktop);
        manaDragon.setCanAttack(true);
        manaDragon.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        JoinHandler.join(desktop,manaDragon);


        return desktop;
    }

    public static Desktop desktop1_3() throws InstantiationException, IllegalAccessException, InvalidOperationException {
        Desktop desktop = new Desktop();

        Player mainPlayer = new Player();
        Hero mainHero = new Rouge(desktop, PlayerType.PLAYER_TYPE_MAIN);
        mainHero.setCanSkill(false);
        mainPlayer.setHero(mainHero);
        desktop.setMainPlayer(mainPlayer);

        Player secondPlayer = new Player();
        Hero secondHero = new Hero(desktop, "敌人",null, PlayerType.PLAYER_TYPE_SECOND);
        secondPlayer.setHero(secondHero);
        desktop.setSecondPlayer(secondPlayer);

        secondHero.setHealth(12);
        mainPlayer.setPower(6);
        mainPlayer.setMaxPower(6);

        StonetuskBoar stonetuskBoar = new StonetuskBoar(desktop);
        AbusiveSergeant abusiveSergeant = new AbusiveSergeant(desktop);
        RockbiterWeapon rockbiterWeapon = new RockbiterWeapon(desktop);
        RockbiterWeapon rockbiterWeapon1 = new RockbiterWeapon(desktop);
        Windfury windfury = new Windfury(desktop);
        TeamLeader teamLeader = new TeamLeader(desktop);
        desktop.getMainCards().add(stonetuskBoar);
        desktop.getMainCards().add(abusiveSergeant);
        desktop.getMainCards().add(rockbiterWeapon);
        desktop.getMainCards().add(rockbiterWeapon1);
        desktop.getMainCards().add(windfury);
        desktop.getMainCards().add(teamLeader);

        return desktop;
    }
}

