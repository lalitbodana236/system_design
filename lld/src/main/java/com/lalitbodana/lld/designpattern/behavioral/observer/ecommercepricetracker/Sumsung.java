package com.lalitbodana.lld.designpattern.behavioral.observer.ecommercepricetracker;

import com.lalitbodana.lld.designpattern.behavioral.observer.ecommercepricetracker.observer.Subscriber;

public class Sumsung extends Product {
    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }
    
    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }
}
