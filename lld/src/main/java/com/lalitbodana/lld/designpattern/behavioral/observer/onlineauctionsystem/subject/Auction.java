package com.lalitbodana.lld.designpattern.behavioral.observer.onlineauctionsystem.subject;

import com.lalitbodana.lld.designpattern.behavioral.observer.onlineauctionsystem.observer.Bidder;

public interface Auction {
    void registerBidder(Bidder bidder);
    
    void removeBidder(Bidder bidder);
    
    void notifyBidders();
    
    void placeBid(Bidder bidder, double amount);
}

