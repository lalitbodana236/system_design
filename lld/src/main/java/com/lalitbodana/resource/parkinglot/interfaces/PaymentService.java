package com.lalitbodana.resource.parkinglot.interfaces;

public interface PaymentService {
    void acceptCash(int amount);

    void acceptCreditCard(String cardNumber, int cvv, int amount);
}
