package com.lalitbodana.lld.behavioral.observerdesignpattern.realworldexample.newsagency;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {
    private final List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void publishNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

