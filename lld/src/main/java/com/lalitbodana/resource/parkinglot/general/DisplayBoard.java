package com.lalitbodana.resource.parkinglot.general;

import com.lalitbodana.resource.parkinglot.enums.ParkingSpotEnum;

import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {

    private static DisplayBoard displayBoard = null;
    private final Map<ParkingSpotEnum, Integer> freeParkingSpots;

    private DisplayBoard() {
        this.freeParkingSpots = new HashMap<>();
    }

    public static DisplayBoard getInstance() {
        if (displayBoard == null) {
            displayBoard = new DisplayBoard();
        }
        return displayBoard;
    }

    public Map<ParkingSpotEnum, Integer> getFreeParkingSpots() {
        return freeParkingSpots;
    }

}
