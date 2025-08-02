package com.lalitbodana.sde.parkinglot.services;

import com.lalitbodana.sde.parkinglot.enums.ParkingEventType;
import com.lalitbodana.sde.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.sde.parkinglot.general.DisplayBoard;
import com.lalitbodana.sde.parkinglot.general.ParkingEvent;
import com.lalitbodana.sde.parkinglot.interfaces.DisplayService;
import com.lalitbodana.sde.parkinglot.interfaces.Observer;

public class DisplayServiceImpl implements DisplayService, Observer {


    @Override
    public void update(ParkingEvent event) {
        int currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(event.getParkingSpotEnum());
        int change = 0;
        if (event.getEventType().equals(ParkingEventType.ENTRY)) {
            change = -1;
        } else {
            change = 1;
        }
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(event.getParkingSpotEnum(), newCount);
    }

    public void update(ParkingSpotEnum parkingSpotEnum, int change) {
        Integer currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(parkingSpotEnum);
        if (currentCount == null) {
            currentCount = 0;
        }
        int newCount = currentCount + change;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(parkingSpotEnum, newCount);

    }
}
