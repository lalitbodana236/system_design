package com.lalitbodana.sde.designpattern.behavioral.observer.onlineauctionsystem;

import com.lalitbodana.sde.designpattern.behavioral.observer.onlineauctionsystem.observer.Bidder;
import com.lalitbodana.sde.designpattern.behavioral.observer.onlineauctionsystem.observer.UserBidder;
import com.lalitbodana.sde.designpattern.behavioral.observer.onlineauctionsystem.subject.ProductAuction;

public class AuctionSystemTest {
    public static void main(String[] args) {
        // Create bidders
        Bidder alice = new UserBidder("Alice");
        Bidder bob = new UserBidder("Bob");
        Bidder charlie = new UserBidder("Charlie");
        
        // Create two auctions
        ProductAuction iphoneAuction = new ProductAuction("iPhone 15");
        ProductAuction ps5Auction = new ProductAuction("PlayStation 5");
        
        // Register bidders to auctions
        iphoneAuction.registerBidder(alice);
        iphoneAuction.registerBidder(bob);
        
        ps5Auction.registerBidder(bob);
        ps5Auction.registerBidder(charlie);
        
        // Place bids
        iphoneAuction.placeBid(alice, 50000);
        iphoneAuction.placeBid(bob, 55000);
        
        ps5Auction.placeBid(charlie, 40000);
        ps5Auction.placeBid(bob, 42000);
    }
}

