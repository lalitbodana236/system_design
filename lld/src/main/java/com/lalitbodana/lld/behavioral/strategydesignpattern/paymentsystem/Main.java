package com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem;

import com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem.strategy.CashPayment;
import com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem.strategy.CreditCardPayment;
import com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem.strategy.DebitCardPayment;
import com.lalitbodana.lld.behavioral.strategydesignpattern.paymentsystem.strategy.UpiPayment;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CashPayment());
        context.pay(100.0);

        context = new PaymentContext(new CreditCardPayment("111111"));
        context.pay(100.0);


        context = new PaymentContext(new DebitCardPayment("1111"));
        context.pay(100.0);

        context = new PaymentContext(new UpiPayment("lalit@ybl.com"));
        context.pay(100.0);


    }
}
