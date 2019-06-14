package com.hrl.design.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: liang
 * @Date: 2019/6/14 11:44
 */
@Component
public class BeansUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeansUtil.applicationContext = applicationContext;
    }

    /**
     * 获取实例
     *
     * @param clazz
     * @return
     */
    public static Object getBean(Class clazz) {
        return applicationContext.getBean(clazz);
    }
}
