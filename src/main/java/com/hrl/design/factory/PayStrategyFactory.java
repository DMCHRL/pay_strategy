package com.hrl.design.factory;

import com.hrl.design.strategy.Pay;
import com.hrl.design.strategy.pay.PayStrategy;
import com.hrl.design.util.BeansUtil;
import org.reflections.Reflections;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: liang
 * @Date: 2019/6/14 11:49
 */
public class PayStrategyFactory {
    // 单例开始

    /**
     * 私有化构造函数，单例
     */
    private PayStrategyFactory() {

    }

    private static class Builder {
        private static final PayStrategyFactory payStrategyFactory = new PayStrategyFactory();
    }

    public static PayStrategyFactory getInstance() {
        return Builder.payStrategyFactory;
    }
    // 单例结束

    private static final String PAY_STRATEGY_IMPLEMENTATION_PACKAGE = "com.hrl.design.service.impl";
    private static final Map<String, Class> STRATEGY_MAP = new HashMap<>();

    // 获取所有支付策略
    static {
        Reflections reflections = new Reflections(PAY_STRATEGY_IMPLEMENTATION_PACKAGE);
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Pay.class);
        classSet.forEach(aClass -> {
            Pay payAnnotation = aClass.getAnnotation(Pay.class);
            STRATEGY_MAP.put(payAnnotation.value(), aClass);
        });
    }

    /**
     * 根据支付策略类型获取支付策略bean
     *
     * @param type
     * @return
     */
    public static PayStrategy getStrategy(String type) {
        // 反射获取支付策略实现类clazz
        Class clazz = STRATEGY_MAP.get(type);
        if (StringUtils.isEmpty(clazz)) {
            return null;
        }

        // 通过applicationContext获取bean
        return (PayStrategy) BeansUtil.getBean(clazz);
    }
}
