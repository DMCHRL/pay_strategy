package com.hrl.design.controller;

import com.hrl.design.service.AbstractPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: liang
 * @Date: 2019/6/14 11:56
 */
@RestController
@RequestMapping("pay")
public class PayController {
    @Autowired
    private AbstractPayService payService;

    @GetMapping
    public void pay(@RequestParam String payType, @RequestParam String payFor) {
        payService.pay(payType, payFor);
    }
}
