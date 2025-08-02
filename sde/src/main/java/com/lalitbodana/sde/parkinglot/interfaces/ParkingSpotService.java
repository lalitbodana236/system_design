package com.lalitbodana.sde.parkinglot.interfaces;

import com.lalitbodana.sde.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;

public interface ParkingSpotService {
    ParkingSpot create(ParkingSpotEnum parkingSpotEnum, Integer floor);
}
