package com.lalitbodana.lld.strategydesignpattern.paymentsystem;

import com.lalitbodana.lld.strategydesignpattern.paymentsystem.strategy.PaymentStrategy;

public class PaymentContext {
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(Double amount) {
        if (paymentStrategy == null) {
            System.out.println("please select a payment method");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
