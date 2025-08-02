package com.lalitbodana.resource.parkinglot.interfaces;

import com.lalitbodana.resource.parkinglot.exceptions.InvalidTicketException;
import com.lalitbodana.resource.parkinglot.general.ParkingTicket;
import com.lalitbodana.resource.parkinglot.general.vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
