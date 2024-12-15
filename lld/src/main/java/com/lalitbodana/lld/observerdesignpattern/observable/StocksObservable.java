package com.lalitbodana.lld.observerdesignpattern.observable;

import com.lalitbodana.lld.observerdesignpattern.observer.NotificationAlertObserver;

public interface StocksObservable {

    void add(NotificationAlertObserver alertObserver);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();

    int getStockCount();

    void setStockCount(int stockCount);
}
