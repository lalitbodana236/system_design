package com.lalitbodana.lld.observerdesignpattern.realworldexample.newsagency;

import com.lalitbodana.lld.observerdesignpattern.realworldexample.newsagency.impl.EmailSubscriber;
import com.lalitbodana.lld.observerdesignpattern.realworldexample.newsagency.impl.MobileSubscriber;

public class ObserverPatternExample {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Observer emailSubscriber = new EmailSubscriber("Alice");
        Observer mobileSubscriber = new MobileSubscriber("Bob");

        newsAgency.addObserver(emailSubscriber);
        newsAgency.addObserver(mobileSubscriber);

        newsAgency.publishNews("Breaking News: Java is awesome!");
        newsAgency.removeObserver(mobileSubscriber);
        newsAgency.publishNews("Update: Observer Pattern made easy!");
    }


}
