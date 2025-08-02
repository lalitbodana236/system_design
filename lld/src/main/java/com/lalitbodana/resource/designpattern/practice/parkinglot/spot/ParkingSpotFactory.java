package com.lalitbodana.resource.designpattern.practice.parkinglot.spot;

public class ParkingSpotFactory {
    
    public static ParkingSpot getFactory(String type) {
        return switch (type) {
            case "MINI" -> new MiniParkingSpot();
            case "COMPACT" -> new CompactParkingSpot();
            default -> throw new RuntimeException("invalid parking spot");
        };
    }
}
