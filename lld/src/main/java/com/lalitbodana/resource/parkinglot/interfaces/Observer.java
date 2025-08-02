package com.lalitbodana.resource.parkinglot.interfaces;

import com.lalitbodana.resource.parkinglot.general.ParkingEvent;

public interface Observer {
    void update(ParkingEvent event);
}
