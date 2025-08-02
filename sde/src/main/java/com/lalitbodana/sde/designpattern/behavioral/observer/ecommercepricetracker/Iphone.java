package com.lalitbodana.sde.designpattern.behavioral.observer.ecommercepricetracker;

import com.lalitbodana.sde.designpattern.behavioral.observer.ecommercepricetracker.observer.Subscriber;

public class Iphone extends Product {
    
    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }
    
    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }
}
