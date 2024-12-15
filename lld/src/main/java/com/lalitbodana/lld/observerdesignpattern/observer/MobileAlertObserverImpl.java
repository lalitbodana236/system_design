package com.lalitbodana.lld.observerdesignpattern.observer;

import com.lalitbodana.lld.observerdesignpattern.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String username;
    StocksObservable observable;

    public MobileAlertObserverImpl(String username, StocksObservable observable) {
        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(username, "product is in stock hurry up");
    }

    private void sendMsgOnMobile(String username, String msg) {
        System.out.println("Msg sent to: " + username);
    }
}
