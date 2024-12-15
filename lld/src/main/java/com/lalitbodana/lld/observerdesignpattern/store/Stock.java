package com.lalitbodana.lld.observerdesignpattern.store;

import com.lalitbodana.lld.observerdesignpattern.observable.IphoneObservalbleImpl;
import com.lalitbodana.lld.observerdesignpattern.observable.StocksObservable;
import com.lalitbodana.lld.observerdesignpattern.observer.EmailAlertObserverImpl;
import com.lalitbodana.lld.observerdesignpattern.observer.NotificationAlertObserver;

public class Stock {
    public static void main(String[] args) {
        StocksObservable iphoneStocksObservable = new IphoneObservalbleImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("uvz@gmail.com", iphoneStocksObservable);
        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        iphoneStocksObservable.setStockCount(10);
    }
}
