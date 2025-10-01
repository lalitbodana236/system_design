package com.lalitbodana.sde.designpattern.practice.parkinglot.strategy;

import com.lalitbodana.sde.designpattern.practice.parkinglot.Ticket;

public interface IFareCalculationStrategy {
    Double calculateFare(Ticket ticket);
}
