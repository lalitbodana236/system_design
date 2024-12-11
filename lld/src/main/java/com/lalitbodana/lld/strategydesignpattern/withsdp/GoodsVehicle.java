package com.lalitbodana.lld.strategydesignpattern.withsdp;

import com.lalitbodana.lld.strategydesignpattern.withsdp.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    public GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
