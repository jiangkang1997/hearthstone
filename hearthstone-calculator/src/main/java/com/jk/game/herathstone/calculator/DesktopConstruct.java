package com.jk.game.herathstone.calculator;

import com.jk.game.hearthstone.card.base.*;
import com.jk.game.hearthstone.card.base.shaman.FlametongueTotem;
import com.jk.game.hearthstone.card.base.shaman.Windfury;
import com.jk.game.hearthstone.card.base.warrior.Warrior;
import com.jk.game.hearthstone.card.base.warrior.Whirlwind;
import com.jk.game.hearthstone.card.classic.mage.FrostArrow;
import com.jk.game.hearthstone.card.classic.mage.IceSpear;
import com.jk.game.hearthstone.card.classic.mage.ManaDragon;
import com.jk.game.hearthstone.card.classic.neutral.AbusiveSergeant;
import com.jk.game.hearthstone.card.classic.neutral.ShieldGuard;
import com.jk.game.hearthstone.card.classic.warror.RiotBerserker;
import com.jk.game.hearthstone.card.classic.warror.ShieldSlam;
import com.jk.game.hearthstone.card.kobolds.IronwoodGolem;
import com.jk.game.hearthstone.card.witch.FuriousWerewolf;
import com.jk.game.hearthstone.core.card.parent.Player;
import com.jk.game.hearthstone.core.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.card.base.rouge.Rouge;
import com.jk.game.hearthstone.card.base.shaman.ShaMan;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.PlayerType;
import com.jk.game.hearthstone.core.exception.InvalidOperationException;
import com.jk.game.hearthstone.core.handler.JoinHandler;

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

        JoinHandler.join(desktop,bluegillWarrior,PlayerType.PLAYER_TYPE_MAIN,0);

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
        JoinHandler.join(desktop,manaDragon,PlayerType.PLAYER_TYPE_MAIN,0);


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

    public static Desktop desktop1_4() throws InstantiationException, IllegalAccessException, InvalidOperationException {
        Desktop desktop = new Desktop();

        Player mainPlayer = new Player();
        Hero mainHero = new ShaMan(desktop, PlayerType.PLAYER_TYPE_MAIN);
        mainHero.setCanSkill(false);
        mainPlayer.setHero(mainHero);
        desktop.setMainPlayer(mainPlayer);

        Player secondPlayer = new Player();
        Hero secondHero = new Hero(desktop, "敌人",null, PlayerType.PLAYER_TYPE_SECOND);
        secondPlayer.setHero(secondHero);
        desktop.setSecondPlayer(secondPlayer);

        secondHero.setHealth(11);
        mainPlayer.setPower(5);
        mainPlayer.setMaxPower(5);

        StonetuskBoar stonetuskBoar = new StonetuskBoar(desktop);
        StonetuskBoar stonetuskBoar1 = new StonetuskBoar(desktop);
        Wolfrider wolfrider = new Wolfrider(desktop);
        desktop.getMainCards().add(stonetuskBoar);
        desktop.getMainCards().add(stonetuskBoar1);
        desktop.getMainCards().add(wolfrider);

        StonetuskBoar stonetuskBoar2 = new StonetuskBoar(desktop);
        FlametongueTotem flametongueTotem = new FlametongueTotem(desktop);
        BluegillWarrior bluegillWarrior = new BluegillWarrior(desktop);
        stonetuskBoar2.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        flametongueTotem.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        bluegillWarrior.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        JoinHandler.join(desktop,stonetuskBoar2,PlayerType.PLAYER_TYPE_MAIN,null);
        JoinHandler.join(desktop,flametongueTotem,PlayerType.PLAYER_TYPE_MAIN,null);
        JoinHandler.join(desktop,bluegillWarrior,PlayerType.PLAYER_TYPE_MAIN,null);

        ShieldGuard shieldGuard = new ShieldGuard(desktop);
        IronfurGrizzly ironfurGrizzly = new IronfurGrizzly(desktop);
        desktop.getSecondMinions().add(shieldGuard);
        desktop.getSecondMinions().add(ironfurGrizzly);

        return desktop;
    }

    public static Desktop desktop1_5() throws InstantiationException, IllegalAccessException, InvalidOperationException {
        Desktop desktop = new Desktop();

        Player mainPlayer = new Player();
        Hero mainHero = new Warrior(desktop, PlayerType.PLAYER_TYPE_MAIN);
        mainPlayer.setHero(mainHero);
        desktop.setMainPlayer(mainPlayer);

        Player secondPlayer = new Player();
        Hero secondHero = new Hero(desktop, "敌人",null, PlayerType.PLAYER_TYPE_SECOND);
        secondPlayer.setHero(secondHero);
        desktop.setSecondPlayer(secondPlayer);

        secondHero.setHealth(11);
        mainPlayer.setPower(10);
        mainPlayer.setMaxPower(10);

        ShieldSlam shieldSlam = new ShieldSlam(desktop);
        Whirlwind whirlwind = new Whirlwind(desktop);
        FuriousWerewolf furiousWerewolf = new FuriousWerewolf(desktop);
        FuriousWerewolf furiousWerewolf1 = new FuriousWerewolf(desktop);
        desktop.getMainCards().add(shieldSlam);
        desktop.getMainCards().add(whirlwind);
        desktop.getMainCards().add(furiousWerewolf);
        desktop.getMainCards().add(furiousWerewolf1);

        RiotBerserker riotBerserker = new RiotBerserker(desktop);
        JoinHandler.join(desktop,riotBerserker,PlayerType.PLAYER_TYPE_MAIN,null);
        riotBerserker.setCanAttack(true);

        IronwoodGolem ironwoodGolem = new IronwoodGolem(desktop);
        JoinHandler.join(desktop,ironwoodGolem,PlayerType.PLAYER_TYPE_SECOND,null);

        return desktop;
    }
}

