package com.lalitbodana.lld.parkinglot.services;

import com.lalitbodana.lld.parkinglot.enums.ParkingEventType;
import com.lalitbodana.lld.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.lld.parkinglot.general.DisplayBoard;
import com.lalitbodana.lld.parkinglot.general.ParkingEvent;
import com.lalitbodana.lld.parkinglot.interfaces.DisplayService;
import com.lalitbodana.lld.parkinglot.interfaces.Observer;

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
