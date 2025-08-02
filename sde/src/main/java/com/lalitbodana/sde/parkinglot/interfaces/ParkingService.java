package com.lalitbodana.sde.parkinglot.interfaces;

import com.lalitbodana.sde.parkinglot.exceptions.InvalidTicketException;
import com.lalitbodana.sde.parkinglot.general.ParkingTicket;
import com.lalitbodana.sde.parkinglot.general.vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
