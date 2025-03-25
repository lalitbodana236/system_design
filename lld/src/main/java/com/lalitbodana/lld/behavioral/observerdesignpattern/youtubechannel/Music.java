package com.lalitbodana.lld.behavioral.observerdesignpattern.youtubechannel;

public class Music extends Channel {
    @Override
    public void uploadVideo() {
        System.out.println("Uploaded new music video");
        notifyObserver();
    }
}
