package com.hrl.design.service.impl;

import com.hrl.design.factory.PayStrategyFactory;
import com.hrl.design.strategy.pay.PayStrategy;
import com.hrl.design.service.AbstractPayService;
import org.springframework.stereotype.Service;

/**
 * @Author: liang
 * @Date: 2019/6/14 11:54
 */
@Service
public class PayServiceImpl extends AbstractPayService {
    /**
     * 支付前准备支付参数
     *
     * @param payFor
     */
    @Override
    public boolean prePay(String payFor) {
        PayStrategy payStrategy = PayStrategyFactory.getStrategy(this.payType);
        if (payStrategy == null) {
            System.out.printf("没有%s类型的支付策略...\r\n", this.payType);
            return false;
        }
        return payStrategy.prePay(payFor);
    }

    /**
     * 支付后处理支付回调结果
     *
     * @param payFor
     * @param isPaySuccess
     */
    @Override
    public void afterPay(String payFor, boolean isPaySuccess) {
        PayStrategy payStrategy = PayStrategyFactory.getStrategy(this.payType);
        payStrategy.afterPay(payFor, true);
    }
}
