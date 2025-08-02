package com.lalitbodana.lld.designpattern.practice.parkinglot.spot;

import com.lalitbodana.lld.designpattern.practice.parkinglot.MiniParkingSpot;

public class ParkingSpotFactory {
    
    public static ParkingSpot getFactory(String type, int floor) {
        return switch (type) {
            case "MINI" -> new MiniParkingSpot(floor);
            case "COMPACT" -> new CompactParkingSpot(floor);
            default -> throw new RuntimeException("invalid parking spot");
        };
    }
}
