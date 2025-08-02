package com.lalitbodana.resource.designpattern.behavioral.observer.store.observable;

import com.lalitbodana.resource.designpattern.behavioral.observer.store.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservalbleImpl implements StocksObservable {
    
    public List<NotificationAlertObserver> observerList = new ArrayList();
    
    public int stockCount = 0;
    
    @Override
    public void add(NotificationAlertObserver alertObserver) {
        observerList.add(alertObserver);
        
    }
    
    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }
    
    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }
    
    @Override
    public int getStockCount() {
        return stockCount;
    }
    
    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount = stockCount + newStockCount;
    }
}
