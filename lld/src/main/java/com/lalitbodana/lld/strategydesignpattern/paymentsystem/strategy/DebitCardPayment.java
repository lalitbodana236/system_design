package com.lalitbodana.lld.strategydesignpattern.paymentsystem.strategy;

public class DebitCardPayment extends CardPayment {

    public DebitCardPayment(String cardNumber) {
        super(cardNumber);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using debit card ");
    }
}
