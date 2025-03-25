package com.lalitbodana.lld.behavioral.strategydesignpattern.withsdp.strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
