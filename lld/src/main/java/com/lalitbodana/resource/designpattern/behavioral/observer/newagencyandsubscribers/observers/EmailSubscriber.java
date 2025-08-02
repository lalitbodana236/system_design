package com.lalitbodana.resource.designpattern.behavioral.observer.newagencyandsubscribers.observers;

public class EmailSubscriber implements Subscribers {
    String email;
    
    public EmailSubscriber(String email) {
        this.email = email;
    }
    
    @Override
    public void update(String news) {
        System.out.println("news is send to this email :" + this.email + " " + news);
    }
}
