package com.lalitbodana.lld.observerdesignpattern.youtubechannel;

import java.util.ArrayList;
import java.util.List;

public class Channel implements ISubject {

    List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver obbserver) {
        observers.add(obbserver);
    }

    @Override
    public void uploadVideo() {
        notifyObserver();
    }

    @Override
    public void notifyObserver() {

        for (IObserver observer : observers) {
            observer.update();
        }
    }
}
