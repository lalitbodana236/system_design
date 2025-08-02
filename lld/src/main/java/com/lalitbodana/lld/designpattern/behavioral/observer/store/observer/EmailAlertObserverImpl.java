package com.lalitbodana.lld.designpattern.behavioral.observer.store.observer;

import com.lalitbodana.lld.designpattern.behavioral.observer.store.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    
    String emailId;
    StocksObservable observable;
    
    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }
    
    @Override
    public void update() {
        sendMail(emailId, "product is in stock hurry up");
    }
    
    private void sendMail(String emailId, String msg) {
        System.out.println("Mail sent to: " + emailId);
    }
}
