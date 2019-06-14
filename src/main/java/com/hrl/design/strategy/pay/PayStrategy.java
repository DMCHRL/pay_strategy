package com.hrl.design.strategy.pay;

/**
 * @Author: liang
 * @Date: 2019/6/14 11:39
 */
public interface PayStrategy {

    /**
     * 支付前准备支付参数
     *
     * @param payFor
     * @return
     */
    boolean prePay(String payFor);

    /**
     * 支付后处理支付回调结果
     *
     * @param payFor
     * @param isPaySuccess
     */
    void afterPay(String payFor, boolean isPaySuccess);
}
