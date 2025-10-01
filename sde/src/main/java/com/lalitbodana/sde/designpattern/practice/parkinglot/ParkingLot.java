package com.lalitbodana.sde.designpattern.practice.parkinglot;

import com.lalitbodana.sde.designpattern.practice.parkinglot.strategy.IFareCalculationStrategy;

import java.util.Map;

public class ParkingLot {
    private final Map<Integer,ParkingFloor> parkingFloorMap;
    
    private final IFareCalculationStrategy fareCalculationStrategy;
    
    public ParkingLot(Map<Integer, ParkingFloor> parkingFloorMap, IFareCalculationStrategy fareCalculationStrategy) {
        this.parkingFloorMap = parkingFloorMap;
        this.fareCalculationStrategy = fareCalculationStrategy;
    }
    
    public void addParkingFloor(ParkingFloor floor){
        this.parkingFloorMap.put(floor.getFloorId(),floor);
    }
    
    public Ticket park(Vehicle vehicle){
        ParkingType type = vehicle.getVehicleType();
        for(Map.Entry<Integer,ParkingFloor> floorEntry : this.parkingFloorMap.entrySet()){
            if(!floorEntry.getValue().getVacantSpots().get(type).isEmpty()){
                ParkingSpot spot = floorEntry.getValue().getVacantSpots().get(type).get(0);
                
                spot.setAvailable(false);
                
                // mark it as occupied
                spot.setAvailable(false);
                
                // move it to occupied spots
                floorEntry.getValue().getVacantSpots().get(type).remove(spot);
                floorEntry.getValue().getOccupiedSpots().get(type).add(spot);
                
                // issue a ticket
                Ticket ticket = new Ticket();
                ticket.setParkingSpot(spot);
                ticket.setVehicle(vehicle);
            }
        
        }
        
        throw new RuntimeException("Parking Lot is full");
    }
    
    public Double unpark(Ticket ticket) {
        // calculate fare
        Double parkingCharges = fareCalculationStrategy.calculateFare(ticket);
       // Double parkingCharges=0.0;
        
        // mark spot as vacant
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setAvailable(true);
        
        // move the spot to vacant list
        this.parkingFloorMap.get(parkingSpot.getFloor()).getOccupiedSpots()
                .get(parkingSpot.getParkingType())
                .remove(parkingSpot);
        
        this.parkingFloorMap.get(parkingSpot.getFloor()).getVacantSpots()
                .get(parkingSpot.getParkingType())
                .add(parkingSpot);
        
        //dashboard.notify(ticket, ParkingEventType.UNPARK);
        return parkingCharges;
    }
}
