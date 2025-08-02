package com.lalitbodana.lld.designpattern.behavioral.observer.newagencyandsubscribers;

import com.lalitbodana.lld.designpattern.behavioral.observer.newagencyandsubscribers.observers.EmailSubscriber;
import com.lalitbodana.lld.designpattern.behavioral.observer.newagencyandsubscribers.observers.SmsSubscriber;
import com.lalitbodana.lld.designpattern.behavioral.observer.newagencyandsubscribers.observers.Subscribers;

public class NewAgencyTestRunner {
    public static void main(String[] args) {
        NewAgency newAgency = new NewAgency();
        
        Subscribers emailSub1 = new EmailSubscriber("lalitbodana@gmail.com");
        Subscribers emailSub2 = new EmailSubscriber("neetubodana@gmail.com");
        Subscribers mobileSub1 = new SmsSubscriber("9098024125");
        Subscribers mobileSub2 = new SmsSubscriber("lalitbodana@gmail.com");
        
        
        newAgency.subcribe(emailSub1);
        newAgency.subcribe(emailSub2);
        newAgency.subcribe(mobileSub1);
        newAgency.subcribe(mobileSub2);
        
        
        newAgency.publish("this the first news it will send to all the subscriber");
        
        newAgency.unsubscribe(mobileSub1);
        newAgency.unsubscribe(mobileSub2);
        
        newAgency.publish("this the second news it will send to all the subscriber");
    }
}
