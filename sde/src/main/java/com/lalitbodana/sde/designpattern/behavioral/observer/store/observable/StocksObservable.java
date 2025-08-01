package com.lalitbodana.sde.designpattern.behavioral.observer.store.observable;

import com.lalitbodana.sde.designpattern.behavioral.observer.store.observer.NotificationAlertObserver;

public interface StocksObservable {
    
    void add(NotificationAlertObserver alertObserver);
    
    void remove(NotificationAlertObserver observer);
    
    void notifySubscribers();
    
    int getStockCount();
    
    void setStockCount(int stockCount);
}
