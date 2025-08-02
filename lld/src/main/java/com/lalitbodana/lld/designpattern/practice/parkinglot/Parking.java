package com.lalitbodana.lld.designpattern.practice.parkinglot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Compact;
import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Mini;
import com.lalitbodana.lld.designpattern.practice.parkinglot.entity.Vehicle;
import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.ParkingSpot;
import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.ParkingSpotFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Parking {
    
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance(3, 3);
        AtomicInteger spotId = new AtomicInteger(1);
        ParkingSpot miniSpot1 = ParkingSpotFactory.getFactory("MINI", spotId.getAndIncrement());
        ParkingSpot miniSpot2 = ParkingSpotFactory.getFactory("MINI", spotId.getAndIncrement());
        ParkingSpot compactSpot1 = ParkingSpotFactory.getFactory("COMPACT", spotId.getAndIncrement());
        
        parkingLot.addParkingSpot(miniSpot1);
        parkingLot.addParkingSpot(miniSpot2);
        parkingLot.addParkingSpot(compactSpot1);
        
        parkingLot.getAvailableSpots();
        
        Vehicle miniVeh1 = new Mini("MP09MM1111");
        Vehicle miniVeh2 = new Mini("MP09MM1112");
        Vehicle miniVeh3 = new Mini("MP09MM1113");
        Vehicle miniVeh4 = new Mini("MP09MM1114");
        
        
        Vehicle compactVeh1 = new Compact("MP09CC1111");
        Vehicle compactVeh2 = new Compact("MP09CC1112");
        
        parkingLot.parkVehicle(miniVeh1);
        parkingLot.parkVehicle(miniVeh2);
        parkingLot.parkVehicle(miniVeh3);
        parkingLot.parkVehicle(compactVeh1);
    }
}
