package com.lalitbodana.lld.observerdesignpattern.store.observable;

import com.lalitbodana.lld.observerdesignpattern.store.observer.NotificationAlertObserver;

public interface StocksObservable {

    void add(NotificationAlertObserver alertObserver);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();

    int getStockCount();

    void setStockCount(int stockCount);
}
