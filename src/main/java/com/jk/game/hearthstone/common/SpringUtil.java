package com.jk.game.hearthstone.common;

import com.jk.game.hearthstone.config.UseCardPostProcessor;
import com.jk.game.hearthstone.config.UseCardPreprocessor;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author jk
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    public static Map<String, UseCardPreprocessor> getPlayPreprocessors(){
        return applicationContext.getBeansOfType(UseCardPreprocessor.class);
    }

    public static Map<String, UseCardPostProcessor> getPlayPostProcessors(){
        return applicationContext.getBeansOfType(UseCardPostProcessor.class);
    }
}
