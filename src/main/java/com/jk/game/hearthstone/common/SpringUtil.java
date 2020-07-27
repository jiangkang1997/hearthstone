package com.jk.game.hearthstone.common;

import com.jk.game.hearthstone.config.PlayPostProcessor;
import com.jk.game.hearthstone.config.PlayPreprocessor;
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

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Map<String, PlayPreprocessor> getPlayPreprocessors(){
        return applicationContext.getBeansOfType(PlayPreprocessor.class);
    }

    public Map<String, PlayPostProcessor> getPlayPostProcessors(){
        return applicationContext.getBeansOfType(PlayPostProcessor.class);
    }
}
