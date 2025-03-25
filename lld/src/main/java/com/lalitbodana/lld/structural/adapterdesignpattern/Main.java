package com.lalitbodana.lld.structural.adapterdesignpattern;

import com.lalitbodana.lld.structural.adapterdesignpattern.adaptee.WeightMachineForBabies;
import com.lalitbodana.lld.structural.adapterdesignpattern.adapter.WeightMachineAdapter;
import com.lalitbodana.lld.structural.adapterdesignpattern.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }

}
