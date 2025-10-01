package com.lalitbodana.sde.designpattern.structural.adapterdesignpattern;

import com.lalitbodana.sde.designpattern.structural.adapterdesignpattern.adaptee.WeightMachineForBabies;
import com.lalitbodana.sde.designpattern.structural.adapterdesignpattern.adapter.WeightMachineAdapter;
import com.lalitbodana.sde.designpattern.structural.adapterdesignpattern.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }

}
