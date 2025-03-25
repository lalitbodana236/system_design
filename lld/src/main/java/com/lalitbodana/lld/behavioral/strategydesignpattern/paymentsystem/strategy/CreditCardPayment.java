package com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem.strategy;

public class CreditCardPayment extends CardPayment {

    public CreditCardPayment(String cardNumber) {
        super(cardNumber);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using credit card ");
    }
}
