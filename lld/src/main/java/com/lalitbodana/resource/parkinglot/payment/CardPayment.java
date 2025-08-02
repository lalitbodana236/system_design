package com.lalitbodana.resource.parkinglot.payment;

public class CardPayment extends Payment {
    private final String cardNumber;
    private final int cvv;

    public CardPayment(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("making payment by card of Rs " + amount);
        return true;
    }
}
