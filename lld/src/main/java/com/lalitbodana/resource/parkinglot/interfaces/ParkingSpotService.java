package com.lalitbodana.resource.parkinglot.interfaces;

import com.lalitbodana.resource.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.resource.parkinglot.general.parkingSpot.ParkingSpot;

public interface ParkingSpotService {
    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor);
}
