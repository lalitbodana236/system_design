package com.lalitbodana.sde.designpattern.facade;

import com.lalitbodana.sde.designpattern.facade.keeper.MenuManager;
import com.lalitbodana.sde.designpattern.facade.service.NonvegResaurant;
import com.lalitbodana.sde.designpattern.facade.service.VegResaurant;

public class Driver {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager(new VegResaurant(),new NonvegResaurant());
        
        System.out.println(menuManager.getNonvegMenu());
        System.out.println(menuManager.getVegMenu());
        System.out.println(menuManager.getBothMenu());
    }
}
