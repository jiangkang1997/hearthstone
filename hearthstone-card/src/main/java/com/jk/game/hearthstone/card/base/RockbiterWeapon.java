package com.jk.game.hearthstone.card.base;

import com.jk.game.hearthstone.core.annotation.TargetScope;
import com.jk.game.hearthstone.core.card.parent.Card;
import com.jk.game.hearthstone.core.card.parent.magic.NormalMagic;
import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.buff.AbstractAttackBuff;
import com.jk.game.hearthstone.core.data.Desktop;
import com.jk.game.hearthstone.core.enumeration.CardType;
import com.jk.game.hearthstone.core.enumeration.Stand;

import static com.jk.game.hearthstone.core.enumeration.Dictionary.MAX_TURN;

/**
 * 石化武器
 * @author jk
 * @date 2021/1/12 22:41
 */
@TargetScope(stand = Stand.FRIEND)
public class RockbiterWeapon extends NormalMagic {

    private static final String NAME = "石化武器";
    private static final String DESC = "在本回合中，使一个友方角色获得+3攻击力";

    public RockbiterWeapon(Desktop desktop) {
        super(desktop, 2, NAME, DESC, CardType.CARD_TYPE_SHAMAN);
    }

    @Override
    public void effect(Desktop desktop, Organism target) {
        RockbiterWeaponBuff buff = new RockbiterWeaponBuff(this);
        target.registerBuff(buff);
    }

    static class RockbiterWeaponBuff extends AbstractAttackBuff{

        private static final int ATTACK_NUM = 3;
        private static final int LIFE = MAX_TURN;

        public RockbiterWeaponBuff(Card owner) {
            super(owner, LIFE, ATTACK_NUM);
        }
    }
}
