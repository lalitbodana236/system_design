package com.lalitbodana.lld.behavioral.observerdesignpattern.realworldexample.newsagency.impl;

import com.lalitbodana.lld.behavioral.observerdesignpattern.realworldexample.newsagency.Observer;

public class MobileSubscriber implements Observer {
    private final String name;

    public MobileSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news via mobile notification: " + news);
    }
}