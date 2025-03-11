package com.lalitbodana.lld.strategydesignpattern.paymentsystem.strategy;

public abstract class CardPayment implements PaymentStrategy {

    protected String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
