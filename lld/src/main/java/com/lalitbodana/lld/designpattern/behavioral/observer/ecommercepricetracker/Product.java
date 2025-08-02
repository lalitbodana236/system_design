package com.lalitbodana.lld.designpattern.behavioral.observer.ecommercepricetracker;

import com.lalitbodana.lld.designpattern.behavioral.observer.ecommercepricetracker.observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    
    protected List<Subscriber> subscriberList = new ArrayList<>();
    
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }
    
    public void unsubscribe(Subscriber subscriber) {
        subscriberList.remove(subscriber);
    }
    
    public void notifyAllSubscribers(String price) {
        for (Subscriber subscriber : subscriberList) {
            subscriber.update(price);
        }
    }
    
    public void updatePrice(String price) {
        System.out.println("Price updated to: " + price);
        notifyAllSubscribers(price);
    }
    
}
