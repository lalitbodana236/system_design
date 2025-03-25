package com.lalitbodana.lld.behavioral.observerdesignpattern.youtubechannel;

public interface ISubject {
    void addObserver(IObserver obbserver);

    void notifyObserver();

    void uploadVideo();
}
