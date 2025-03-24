package com.lalitbodana.lld.adapterdesignpattern.adapter;


import com.lalitbodana.lld.adapterdesignpattern.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {

    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg() {

        double weightInPound = weightMachine.getWeightInPound();

        //Convert it to KGs
        double weightInKg = weightInPound * .45;
        return weightInKg;
    }
}

