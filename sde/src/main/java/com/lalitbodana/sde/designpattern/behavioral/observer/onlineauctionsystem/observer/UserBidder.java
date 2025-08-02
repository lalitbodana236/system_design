package com.lalitbodana.sde.designpattern.behavioral.observer.onlineauctionsystem.observer;

public class UserBidder implements Bidder {
    private final String name;
    
    public UserBidder(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String itemName, double newBid) {
        System.out.println("[" + name + "] New highest bid on " + itemName + ": ₹" + newBid);
    }
    
    @Override
    public String getName() {
        return name;
    }
}

