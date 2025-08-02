package com.lalitbodana.sde.designpattern.behavioral.observer.eventmanagementsystem;

import com.lalitbodana.sde.designpattern.behavioral.observer.eventmanagementsystem.observer.EventAttendee;
import com.lalitbodana.sde.designpattern.behavioral.observer.eventmanagementsystem.subject.TechEvent;

public class EventTestRunner {
    public static void main(String[] args) {
        TechEvent event = new TechEvent("JavaCon", "10:00 AM", "Auditorium A");
        
        EventAttendee user1 = new EventAttendee("Lalit");
        EventAttendee user2 = new EventAttendee("Neetu");
        
        event.registerAttendee(user1);
        event.registerAttendee(user2);
        
        event.updateTime("11:30 AM");
        event.updateLocation("Hall B");
        
        event.removeAttendee(user1);
        event.updateLocation("Main Conference Room");
    }
}
