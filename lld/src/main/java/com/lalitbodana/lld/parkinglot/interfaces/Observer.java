package com.lalitbodana.lld.parkinglot.interfaces;

import com.lalitbodana.lld.parkinglot.general.ParkingEvent;

public interface Observer {
    void update(ParkingEvent event);
}
