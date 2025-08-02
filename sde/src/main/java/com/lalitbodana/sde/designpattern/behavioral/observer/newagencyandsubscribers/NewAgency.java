package com.lalitbodana.sde.designpattern.behavioral.observer.newagencyandsubscribers;

import com.lalitbodana.sde.designpattern.behavioral.observer.newagencyandsubscribers.observers.Subscribers;

import java.util.ArrayList;
import java.util.List;

public class NewAgency {
    List<Subscribers> subscribersList;
    
    public NewAgency() {
        this.subscribersList = new ArrayList<>();
    }
    
    public void subcribe(Subscribers subscribers) {
        subscribersList.add(subscribers);
    }
    
    public void unsubscribe(Subscribers subscribers) {
        subscribersList.remove(subscribers);
    }
    
    private void notifyAllSubscribers(String news) {
        for (Subscribers subscribers : subscribersList) {
            subscribers.update(news);
        }
    }
    
    public void publish(String news) {
        notifyAllSubscribers(news);
    }
}
