package com.lalitbodana.lld.behavioral.strategydesignpattern.questions.store.impl;

public class CardPaymentStrategy implements PaymentStrategy {

    private final String name;
    private final String cardNumber;
    private final String cvv;
    private final String dateOfExpiry;

    public CardPaymentStrategy(String nm, String ccNum, String cvv, String expiryDate) {
        this.name = nm;
        this.cardNumber = ccNum;
        this.cvv = cvv;
        this.dateOfExpiry = expiryDate;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }
}
