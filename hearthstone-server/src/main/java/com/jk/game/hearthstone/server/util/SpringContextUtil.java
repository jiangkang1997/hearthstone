package com.jk.game.hearthstone.server.util;

import com.jk.game.hearthstone.server.annotation.Command;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author jk
 * @date 2021/2/13 19:59
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T> Map<String, T> getBeanByType(Class<T> clazz){
        return applicationContext.getBeansOfType(clazz);
    }
}
