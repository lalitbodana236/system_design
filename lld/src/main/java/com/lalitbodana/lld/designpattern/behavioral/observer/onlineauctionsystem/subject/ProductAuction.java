package com.lalitbodana.lld.designpattern.behavioral.observer.onlineauctionsystem.subject;

import com.lalitbodana.lld.designpattern.behavioral.observer.onlineauctionsystem.observer.Bidder;

import java.util.ArrayList;
import java.util.List;

public class ProductAuction implements Auction {
    private final String itemName;
    private final List<Bidder> bidders = new ArrayList<>();
    private double highestBid = 0.0;
    private Bidder highestBidder = null;
    
    public ProductAuction(String itemName) {
        this.itemName = itemName;
    }
    
    @Override
    public void registerBidder(Bidder bidder) {
        bidders.add(bidder);
    }
    
    @Override
    public void removeBidder(Bidder bidder) {
        bidders.remove(bidder);
    }
    
    @Override
    public void notifyBidders() {
        for (Bidder bidder : bidders) {
            if (!bidder.equals(highestBidder)) {
                bidder.update(itemName, highestBid);
            }
        }
    }
    
    @Override
    public void placeBid(Bidder bidder, double amount) {
        if (amount > highestBid) {
            highestBid = amount;
            highestBidder = bidder;
            System.out.println("[" + bidder.getName() + "] placed the highest bid of ₹" + amount + " on " + itemName);
            notifyBidders();
        } else {
            System.out.println("[" + bidder.getName() + "]'s bid of ₹" + amount + " is lower than current highest bid on " + itemName);
        }
    }
}

