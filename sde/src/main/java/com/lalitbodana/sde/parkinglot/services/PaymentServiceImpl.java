package com.lalitbodana.sde.parkinglot.services;


import com.lalitbodana.sde.parkinglot.interfaces.PaymentService;
import com.lalitbodana.sde.parkinglot.payment.CardPayment;
import com.lalitbodana.sde.parkinglot.payment.CashPayment;
import com.lalitbodana.sde.parkinglot.payment.Payment;

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
