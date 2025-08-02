package com.lalitbodana.lld.designpattern.behavioral.observer.store;

import com.lalitbodana.lld.designpattern.behavioral.observer.store.observable.IphoneObservalbleImpl;
import com.lalitbodana.lld.designpattern.behavioral.observer.store.observable.StocksObservable;
import com.lalitbodana.lld.designpattern.behavioral.observer.store.observer.EmailAlertObserverImpl;
import com.lalitbodana.lld.designpattern.behavioral.observer.store.observer.MobileAlertObserverImpl;
import com.lalitbodana.lld.designpattern.behavioral.observer.store.observer.NotificationAlertObserver;

public class Stock {
    public static void main(String[] args) {
        StocksObservable iphoneStocksObservable = new IphoneObservalbleImpl();
        
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("uvz@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer4 = new MobileAlertObserverImpl("9098024125", iphoneStocksObservable);
        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);
        iphoneStocksObservable.add(observer4);
        
        iphoneStocksObservable.setStockCount(10);
    }
}
