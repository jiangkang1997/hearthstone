package com.jk.game.hearthstone.annotation;


import com.jk.game.hearthstone.card.parent.organism.Organism;
import com.jk.game.hearthstone.enumeration.Stand;

import java.lang.annotation.*;


/**
 * @author jk
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetScope {

    Class<? extends Organism> classScope() default Organism.class;
    Stand stand() default Stand.ALL;
}
