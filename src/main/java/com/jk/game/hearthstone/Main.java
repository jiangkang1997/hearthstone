package com.jk.game.hearthstone;

import com.jk.game.hearthstone.calculator.DesktopConstruct;
import com.jk.game.hearthstone.card.base.StonetuskBoar;
import com.jk.game.hearthstone.card.base.TeamLeader;
import com.jk.game.hearthstone.card.classic.mage.FrostArrow;
import com.jk.game.hearthstone.card.classic.mage.IceSpear;
import com.jk.game.hearthstone.card.classic.mage.ManaDragon;
import com.jk.game.hearthstone.card.parent.Player;
import com.jk.game.hearthstone.card.classic.neutral.AbusiveSergeant;
import com.jk.game.hearthstone.card.classic.neutral.Wisp;
import com.jk.game.hearthstone.card.parent.organism.hero.Hero;
import com.jk.game.hearthstone.common.MinionCollection;
import com.jk.game.hearthstone.core.handler.JoinHandler;
import com.jk.game.hearthstone.core.handler.SimpleAttackHandler;
import com.jk.game.hearthstone.core.handler.UseCardHandler;
import com.jk.game.hearthstone.data.Desktop;
import com.jk.game.hearthstone.enumeration.PlayerType;
import com.jk.game.hearthstone.exception.IllegalOperationException;
import com.jk.game.hearthstone.exception.InvalidOperationException;

/**
 * @author jk
 */
public class Main {

    public static void main(String[] args) throws IllegalOperationException, CloneNotSupportedException, IllegalAccessException, InvalidOperationException, InstantiationException {
        Desktop desktop = DesktopConstruct.desktop1_3();

        StonetuskBoar stonetuskBoar = new StonetuskBoar(desktop);
        stonetuskBoar.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);
        TeamLeader teamLeader = new TeamLeader(desktop);
        teamLeader.setPlayerType(PlayerType.PLAYER_TYPE_MAIN);

        JoinHandler.join(desktop,stonetuskBoar);
        JoinHandler.join(desktop,teamLeader);

        System.out.println(stonetuskBoar.getAttack());

    }
}
