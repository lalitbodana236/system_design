package com.lalitbodana.lld.designpattern.practice.parkinglot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.dto.*;
import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.CompactParkingSpot;
import com.lalitbodana.lld.designpattern.practice.parkinglot.spot.MiniParkingSpot;

public class Parking {
    
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance();
        
        ParkingFloor floor0 = new ParkingFloor(0, 2);
        floor0.addSpot(new MiniParkingSpot());
        floor0.addSpot(new CompactParkingSpot());
        
        ParkingFloor floor1 = new ParkingFloor(1, 5);
        floor1.addSpot(new MiniParkingSpot());
        floor1.addSpot(new CompactParkingSpot());
        
        lot.addFloor(0, floor0);
        lot.addFloor(1, floor1);
        lot.displayAvailableSpots();
        Vehicle car1 = new Compact("GJ05AB1234");
        Vehicle car2 = new Mini("MH12CD4567");
        
        Ticket ticket1 = lot.parkVehicle(car1);
        Ticket ticket2 = lot.parkVehicle(car2);
        
        lot.displayAvailableSpots();
        
        
        lot.leaveVehicle(ticket2);
        lot.displayAvailableSpots();
        lot.leaveVehicle(ticket1);
        
        lot.displayAvailableSpots();
        
    }
}
