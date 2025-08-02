package com.lalitbodana.lld.companywise.amazon.lld.splitwise.dto;

public abstract class Split {
    String userId;
    
    int amount;
    
    public Split(String userId) {
        this.userId = userId;
    }
    
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
