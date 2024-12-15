package com.lalitbodana.lld.observerdesignpattern.youtubechannel;

public class User implements IObserver {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void update() {
        System.out.println("Hello " + this.name + ", please check the new video");
    }
}
