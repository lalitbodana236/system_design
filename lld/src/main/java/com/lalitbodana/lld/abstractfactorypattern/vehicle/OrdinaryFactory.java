package com.lalitbodana.lld.abstractfactorypattern.vehicle;

public class OrdinaryFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("V1")) {
            return new OrdinaryV1();
        } else if (type.equalsIgnoreCase("V2")) {
            return new OrdinaryV2();
        }
        return null;
    }
}
