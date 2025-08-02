package com.lalitbodana.lld.designpattern.behavioral.observer.eventmanagementsystem.subject;

import com.lalitbodana.lld.designpattern.behavioral.observer.eventmanagementsystem.observer.Attendee;

import java.util.ArrayList;
import java.util.List;

public class TechEvent implements Event {
    private final List<Attendee> attendees = new ArrayList<>();
    private final String name;
    private String time;
    private String location;
    
    public TechEvent(String name, String time, String location) {
        this.name = name;
        this.time = time;
        this.location = location;
    }
    
    public void updateTime(String newTime) {
        this.time = newTime;
        notifyAttendees("Time updated to: " + newTime);
    }
    
    public void updateLocation(String newLocation) {
        this.location = newLocation;
        notifyAttendees("Location changed to: " + newLocation);
    }
    
    @Override
    public void registerAttendee(Attendee attendee) {
        attendees.add(attendee);
        notifyAttendee(attendee, "you regested succefully");
    }
    
    @Override
    public void removeAttendee(Attendee attendee) {
        attendees.remove(attendee);
        notifyAttendee(attendee, "remove from mailing list");
    }
    
    @Override
    public void notifyAttendees(String message) {
        for (Attendee attendee : attendees) {
            attendee.update(message);
        }
    }
    
    @Override
    public void notifyAttendee(Attendee attendee, String message) {
        attendee.update(message);
    }
}

