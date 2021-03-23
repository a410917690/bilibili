package org.lanqiao.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(String id){
        return context.getBean(id);
    }

    public static Object getBean(Class clazz){
        return context.getBean(clazz);
    }

    public static Object getBean(String id,Class clazz){
        return context.getBean(id,clazz);
    }

}
