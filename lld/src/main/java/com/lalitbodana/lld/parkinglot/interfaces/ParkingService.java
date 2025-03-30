package com.lalitbodana.lld.parkinglot.interfaces;

import com.lalitbodana.lld.parkinglot.exceptions.InvalidTicketException;
import com.lalitbodana.lld.parkinglot.general.ParkingTicket;
import com.lalitbodana.lld.parkinglot.general.vehicle.Vehicle;

public interface ParkingService {
    ParkingTicket entry(Vehicle vehicle);

    int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
