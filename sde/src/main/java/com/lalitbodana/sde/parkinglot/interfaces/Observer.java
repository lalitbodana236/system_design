package com.lalitbodana.sde.parkinglot.interfaces;

import com.lalitbodana.sde.parkinglot.general.ParkingEvent;

public interface Observer {
    void update(ParkingEvent event);
}
