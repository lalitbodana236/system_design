package com.lalitbodana.sde.designpattern.behavioral.observer.newagencyandsubscribers.observers;

public class SmsSubscriber implements Subscribers {
    String mobile;
    
    public SmsSubscriber(String mobile) {
        this.mobile = mobile;
    }
    
    @Override
    public void update(String news) {
        System.out.println("news is sent to this number : " + this.mobile + " " + news);
    }
}
