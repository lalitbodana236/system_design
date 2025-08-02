package com.lalitbodana.lld.designpattern.behavioral.observer.youtubechannel;

public interface ISubject {
    void addObserver(IObserver obbserver);
    
    void notifyObserver();
    
    void uploadVideo();
}
