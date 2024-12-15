package com.lalitbodana.lld.observerdesignpattern.youtubechannel;

public interface ISubject {
    void addObserver(IObserver obbserver);

    void notifyObserver();

    void uploadVideo();
}
