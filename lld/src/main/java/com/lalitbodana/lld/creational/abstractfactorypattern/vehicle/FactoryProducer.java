package com.lalitbodana.lld.creational.abstractfactorypattern.vehicle;

public class FactoryProducer {
    public static VehicleFactory getFactory(String factoryType) {
        if (factoryType.equalsIgnoreCase("ORDINARY")) {
            return new OrdinaryFactory();
        } else if (factoryType.equalsIgnoreCase("LUXURY")) {
            return new LuxuryFactory();
        }
        return null;
    }
}
