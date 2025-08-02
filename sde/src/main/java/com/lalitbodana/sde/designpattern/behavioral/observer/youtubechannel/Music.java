package com.lalitbodana.sde.designpattern.behavioral.observer.youtubechannel;

public class Music extends Channel {
    @Override
    public void uploadVideo() {
        System.out.println("Uploaded new music video");
        notifyObserver();
    }
}
