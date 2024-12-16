package com.lalitbodana.lld.observerdesignpattern.realworldexample.newsagency.impl;

import com.lalitbodana.lld.observerdesignpattern.realworldexample.newsagency.Observer;

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