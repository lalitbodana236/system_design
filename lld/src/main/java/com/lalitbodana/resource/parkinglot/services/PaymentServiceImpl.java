package com.lalitbodana.resource.parkinglot.services;


import com.lalitbodana.resource.parkinglot.interfaces.PaymentService;
import com.lalitbodana.resource.parkinglot.payment.CardPayment;
import com.lalitbodana.resource.parkinglot.payment.CashPayment;
import com.lalitbodana.resource.parkinglot.payment.Payment;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public void acceptCash(int amount) {
        Payment cash = new CashPayment();
        cash.initiatePayment(amount);
    }

    @Override
    public void acceptCreditCard(String cardNumber, int cvv, int amount) {
        Payment creditCard = new CardPayment(cardNumber, cvv);
        creditCard.initiatePayment(amount);
    }
}
