package com.hrl.design.service.impl;

import com.hrl.design.strategy.Pay;
import com.hrl.design.strategy.pay.PayStrategy;
import org.springframework.stereotype.Service;

/**
 * @Author: liang
 * @Date: 2019/6/14 11:41
 */
@Service
@Pay("test")
public class TestPay implements PayStrategy {
    /**
     * 支付前准备支付参数
     *
     * @param payFor
     */
    @Override
    public boolean prePay(String payFor) {
        System.out.printf("-----------%s-----------\r\n", "测试支付");
        return true;
    }

    /**
     * 支付后处理支付回调结果
     *
     * @param payFor
     * @param isPaySuccess
     */
    @Override
    public void afterPay(String payFor, boolean isPaySuccess) {
        System.out.printf("-----------%s-----------\n", "测试支付");
    }
}
