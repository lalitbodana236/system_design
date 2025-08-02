package com.lalitbodana.sde.parkinglot.services;

import com.lalitbodana.sde.parkinglot.enums.ParkingEventType;
import com.lalitbodana.sde.parkinglot.enums.ParkingSpotEnum;
import com.lalitbodana.sde.parkinglot.exceptions.InvalidTicketException;
import com.lalitbodana.sde.parkinglot.general.ParkingEvent;
import com.lalitbodana.sde.parkinglot.general.ParkingLot;
import com.lalitbodana.sde.parkinglot.general.ParkingTicket;
import com.lalitbodana.sde.parkinglot.general.parkingSpot.ParkingSpot;
import com.lalitbodana.sde.parkinglot.general.parkingSpot.parkingspotdecorator.Wash;
import com.lalitbodana.sde.parkinglot.general.vehicle.Vehicle;
import com.lalitbodana.sde.parkinglot.interfaces.DisplayService;
import com.lalitbodana.sde.parkinglot.interfaces.Observer;
import com.lalitbodana.sde.parkinglot.interfaces.ParkingService;
import com.lalitbodana.sde.parkinglot.parkingstrategy.Strategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingServiceImpl implements ParkingService {

    Strategy parkingStrategy;
    ParkingLot parkingLot;
    DisplayService displayService;
    private final List<Observer> observers;

    public ParkingServiceImpl(Strategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
        parkingLot = ParkingLot.getInstance();
        displayService = new DisplayServiceImpl();
        observers = new ArrayList<>();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        ParkingSpotEnum parkingSpotEnum = vehicle.getParkingSpotEnum();
        List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(parkingSpotEnum);
        List<ParkingSpot> occupiedParkingSpots = parkingLot.getOccupiedParkingSpots().get(parkingSpotEnum);


        try {
            ParkingSpot parkingSpot = parkingStrategy.findParkingSpot(parkingSpotEnum);

            if (parkingSpot.isFree()) {
                synchronized (parkingSpot) {
                    if (parkingSpot.isFree()) {
                        parkingSpot.setFree(false);
                        freeParkingSpots.remove(parkingSpot);
                        occupiedParkingSpots.add(parkingSpot);
                        ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSpot);

                        ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.ENTRY, parkingSpotEnum);
                        notifyAllObservers(parkingEvent);
                        return parkingTicket;
                    }
                    entry(vehicle);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;

    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers(ParkingEvent parkingEvent) {
        for (Observer observer : observers) {
            observer.update(parkingEvent);
        }
    }

    private void addParkingSpotInFreeList(List<ParkingSpot> parkingSpots, ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void addWash(ParkingTicket parkingTicket) {
        parkingTicket.setParkingSpot(new Wash(parkingTicket.getParkingSpot()));
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if (parkingTicket.getVehicle().equals(vehicle)) {
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            int amount = parkingSpot.getAmount();
            parkingSpot.setFree(true);
            parkingLot.getOccupiedParkingSpots().get(vehicle.getParkingSpotEnum()).remove(parkingSpot);
            addParkingSpotInFreeList(parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotEnum()), parkingSpot);

            ParkingEvent parkingEvent = new ParkingEvent(ParkingEventType.EXIT, vehicle.getParkingSpotEnum());
            notifyAllObservers(parkingEvent);
            return amount;
        } else {
            throw new InvalidTicketException("This is an invalid ticket");
        }

    }
}
