package com.jk.game.hearthstone.core.annotation;


import com.jk.game.hearthstone.core.card.parent.organism.Organism;
import com.jk.game.hearthstone.core.enumeration.Stand;

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
