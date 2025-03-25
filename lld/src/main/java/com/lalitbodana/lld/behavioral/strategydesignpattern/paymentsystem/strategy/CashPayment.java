package com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem.strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using cash ");
    }
}
