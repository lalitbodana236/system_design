package com.lalitbodana.sde.designpattern.behavioral.observer.eventmanagementsystem.subject;

import com.lalitbodana.sde.designpattern.behavioral.observer.eventmanagementsystem.observer.Attendee;

public interface Event {
    void registerAttendee(Attendee attendee);
    
    void removeAttendee(Attendee attendee);
    
    void notifyAttendees(String message);
    
    
    void notifyAttendee(Attendee attendee, String message);
}

