package com.lalitbodana.resource.designpattern.behavioral.observer.eventmanagementsystem.observer;

public class EventAttendee implements Attendee {
    private final String name;
    
    public EventAttendee(String name) {
        this.name = name;
    }
    
    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + ": " + message);
    }
}

