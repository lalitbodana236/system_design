package com.lalitbodana.sde.parkinglot.parkingstrategy;

import com.lalitbodana.sde.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.sde.parkinglot.exceptions.SpotNotFoundException;
import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
