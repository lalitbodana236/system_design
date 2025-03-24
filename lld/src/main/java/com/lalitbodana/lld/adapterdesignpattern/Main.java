package com.lalitbodana.lld.adapterdesignpattern;

import com.lalitbodana.lld.adapterdesignpattern.adaptee.WeightMachineForBabies;
import com.lalitbodana.lld.adapterdesignpattern.adapter.WeightMachineAdapter;
import com.lalitbodana.lld.adapterdesignpattern.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }

}
