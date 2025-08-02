package com.lalitbodana.lld.designpattern.behavioral.observer.ecommercepricetracker.observer;

public class Notification implements Subscriber {
    
    String username;
    
    public Notification(String username) {
        this.username = username;
    }
    
    @Override
    public void update(String price) {
        System.out.println("Notification sent to " + username + ": New Price - " + price);
    }
}
