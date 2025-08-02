package com.lalitbodana.resource.designpattern.behavioral.observer.ecommercepricetracker;

import com.lalitbodana.resource.designpattern.behavioral.observer.ecommercepricetracker.observer.Notification;

public class ECommercePriceTrackerTestRunner {
    public static void main(String[] args) {
        Product iphone1 = new Iphone();
        Product iphone2 = new Iphone();
        
        Product sam1 = new Sumsung();
        Product sam2 = new Sumsung();
        
        Notification not1 = new Notification("iphone@gmail.com");
        Notification not2 = new Notification("sam@gmail.com");
        iphone1.subscribe(not1);
        sam1.subscribe(not2);
        sam1.subscribe(not1);
        
        
        iphone1.updatePrice("100RS");
        iphone1.updatePrice("101RS");
        sam1.updatePrice("200RS");
        sam1.updatePrice("203RS");
    }
}
