package com.lalitbodana.sde.designpattern.facade.keeper;

import com.lalitbodana.sde.designpattern.facade.service.Hotel;

public class MenuManager {
    
    private final Hotel vegRestaurant;
    private final Hotel nonvegRestaurant;
    
    public MenuManager(final Hotel vegRestaurant, final Hotel nonvegRestaurant) {
        this.vegRestaurant = vegRestaurant;
        this.nonvegRestaurant = nonvegRestaurant;
    }
    
    public String getVegMenu(){
        return "veg menu";
    }
    
    public String getNonvegMenu(){
        return "non veg menu";
    }
    
    public String getBothMenu(){
        return getVegMenu() +" "+getNonvegMenu();
    }
    
}
