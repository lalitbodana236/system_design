package com.lalitbodana.lld.strategydesignpattern.withsdp;

import com.lalitbodana.lld.strategydesignpattern.withsdp.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }

}
