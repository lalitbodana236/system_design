package com.lalitbodana.sde.designpattern.practice.parkinglot;

import com.lalitbodana.sde.designpattern.practice.parkinglot.dto.ParkingFloor;
import com.lalitbodana.sde.designpattern.practice.parkinglot.dto.Ticket;
import com.lalitbodana.sde.designpattern.practice.parkinglot.dto.Vehicle;
import com.lalitbodana.sde.designpattern.practice.parkinglot.spot.ParkingSpot;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot INSTANCE;
    
    private Map<Integer, ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;
    
    private ParkingLot() {
        this.floors = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }
    
    public static ParkingLot getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLot();
        }
        return INSTANCE;
    }
    
    public void addFloor(int floorNumber, ParkingFloor floor) {
        floors.put(floorNumber, floor);
    }
    
    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors.values()) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) {
                spot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle.getLicensePlate(), floor.getFloorNumber(), spot.getId());
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        System.out.println("No available spot for vehicle " + vehicle.getLicensePlate());
        return null;
    }
    
    public void leaveVehicle(Ticket ticket) {
        
        if (ticket == null) {
            System.out.println("Invalid ticket");
            return;
        }
        
        if (activeTickets.get(ticket.getTicketId()) != null) {
            ParkingFloor floor = floors.get(ticket.getFloorNumber());
            for (ParkingSpot spot : floor.spots) {
                if (spot.getId() == ticket.getSpotId()) {
                    spot.freeSpot();
                    break;
                }
            }
            ticket.setExitTime(new Date());
            
            activeTickets.remove(ticket.getTicketId());
            
            priceCalculation(ticket);
        }
        
        
    }
    
    public void priceCalculation(Ticket ticket) {
        if (ticket != null && ticket.getEntryTime() != null && ticket.getExitTime() != null) {
            long durationInMillis = ticket.getExitTime().getTime() - ticket.getEntryTime().getTime();
            long durationInHours = (long) Math.ceil(durationInMillis / (1000.0 * 60 * 60)); // Round up to next hour
            
            long amount = 0;
            if (durationInHours <= 1) {
                amount = 20; // ₹20 for first hour
            } else {
                amount = 20 + (durationInHours - 1) * 10; // ₹10 for each extra hour
            }
            System.out.println("**************TICKET**************");
            System.out.println("Parking duration: " + durationInHours + " hour(s)");
            System.out.println("Total parking fee: ₹" + amount);
            System.out.println("**********************************");
        } else {
            System.out.println("Ticket is invalid or entry/exit time not set.");
        }
    }
    
    public void displayAvailableSpots() {
        System.out.println("-------------DISPLAY-------------");
        for (ParkingFloor floor : floors.values()) {
            System.out.println("Floor " + floor.getFloorNumber() + " Spot Stats: Floor Total Capacity: " + floor.capacity);
            Map<String, ParkingFloor.SpotCount> stats = floor.getSpotStatsByType();
            int totalCapacity = 0;
            
            for (Map.Entry<String, ParkingFloor.SpotCount> entry : stats.entrySet()) {
                String type = entry.getKey();
                ParkingFloor.SpotCount count = entry.getValue();
                System.out.println("  Spot Type: " + type + " | Total: " + count.total + " | Available: " + count.available);
            }
            System.out.println("-------------DISPLAY-------------");
            System.out.println();
        }
    }
}

