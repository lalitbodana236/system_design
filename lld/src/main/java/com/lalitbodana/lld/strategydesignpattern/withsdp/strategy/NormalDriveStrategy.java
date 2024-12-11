package com.lalitbodana.lld.strategydesignpattern.withsdp.strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
