package com.lalitbodana.resource.designpattern.behavioral.observer.onlineauctionsystem.observer;

public interface Bidder {
    void update(String itemName, double newBid);
    
    String getName();
}

