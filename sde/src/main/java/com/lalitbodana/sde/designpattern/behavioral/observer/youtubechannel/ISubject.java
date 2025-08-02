package com.lalitbodana.sde.designpattern.behavioral.observer.youtubechannel;

public interface ISubject {
    void addObserver(IObserver obbserver);
    
    void notifyObserver();
    
    void uploadVideo();
}
