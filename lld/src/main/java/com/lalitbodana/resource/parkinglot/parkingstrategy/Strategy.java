package com.lalitbodana.resource.parkinglot.parkingstrategy;

import com.lalitbodana.resource.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.resource.parkinglot.exceptions.SpotNotFoundException;
import com.lalitbodana.resource.parkinglot.general.parkingSpot.ParkingSpot;

public interface Strategy {
    ParkingSpot findParkingSpot(ParkingSpotEnum parkingSpotEnum) throws SpotNotFoundException;
}
