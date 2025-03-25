package com.lalitbodana.lld.behavioral.observerdesignpattern.store.observable;

import com.lalitbodana.lld.behavioral.observerdesignpattern.store.observer.NotificationAlertObserver;

public interface StocksObservable {

    void add(NotificationAlertObserver alertObserver);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();

    int getStockCount();

    void setStockCount(int stockCount);
}
