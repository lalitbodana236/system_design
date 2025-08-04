package com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto;

public enum Size {
    SMALL,MEDIUM,LARGE;
    
    public boolean canFit(Size size){
        return size.ordinal()<=this.ordinal();
    }
}
