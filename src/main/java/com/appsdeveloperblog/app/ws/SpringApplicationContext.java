package com.appsdeveloperblog.app.ws;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {
    private static ApplicationContext Context;

        @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException{
            Context = context;
        }

        public static Object getBean(String beanName){
            return Context.getBean(beanName);
        }
}
