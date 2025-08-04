package com.lalitbodana.sde.companywise.amazon.lld.amazonlockeros.dto;

public class Locker implements Comparable<Locker>{
    private Integer id;
    
    private Size size;
    
    private LockerState lockerState;
    
    public Locker(int id,Size size) {
        this.id= id;
        this.size=size;
        this.lockerState=LockerState.FREE;
    }
    
    public synchronized void occupy(){
        this.lockerState=LockerState.OCCUPIED;
    }
    
    public synchronized void vaccant(){
        this.lockerState=LockerState.FREE;
    }
    
    public Integer getId() {
        return id;
    }
    
    public Size getSize() {
        return size;
    }
    
    public LockerState getLockerState() {
        return lockerState;
    }
    
    public void setLockerState(LockerState lockerState) {
        this.lockerState = lockerState;
    }
    
    public void setSize(Size size) {
        this.size = size;
    }
    
    @Override
    public int compareTo(Locker o) {
        return 0;
    }
}
