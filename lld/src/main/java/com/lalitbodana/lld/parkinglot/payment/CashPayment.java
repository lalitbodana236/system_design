package com.lalitbodana.lld.parkinglot.payment;

public class CashPayment extends Payment {
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("making payment by cash of Rs " + amount);
        return true;
    }
}
