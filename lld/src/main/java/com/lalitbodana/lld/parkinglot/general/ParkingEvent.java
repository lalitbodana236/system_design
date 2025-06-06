package com.lalitbodana.lld.parkinglot.general;

import com.lalitbodana.lld.parkinglot.enums.ParkingEventType;
import com.lalitbodana.lld.parkinglot.enums.ParkingSpotEnum;

public class ParkingEvent {
    private ParkingEventType eventType;
    private ParkingSpotEnum parkingSpotEnum;

    public ParkingEvent(ParkingEventType eventType, ParkingSpotEnum parkingSpotEnum) {
        this.eventType = eventType;
        this.parkingSpotEnum = parkingSpotEnum;
    }

    public ParkingEventType getEventType() {
        return eventType;
    }

    public void setEventType(ParkingEventType eventType) {
        this.eventType = eventType;
    }

    public ParkingSpotEnum getParkingSpotEnum() {
        return parkingSpotEnum;
    }

    public void setParkingSpotEnum(ParkingSpotEnum parkingSpotEnum) {
        this.parkingSpotEnum = parkingSpotEnum;
    }
}
