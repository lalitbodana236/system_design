package com.lalitbodana.sde.companywise.amazon.lld.splitwise.dto;

import java.util.List;
import java.util.UUID;

public class Expense {
    
    String id;
    
    int amount;
    
    String paidBy;
    
    SplitType type;
    
    List<Split> splits;
    
    public Expense(int amount, String paidBy, SplitType type, List<Split> splits) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.type = type;
        this.splits = splits;
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId() {
        return id;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getPaidBy() {
        return paidBy;
    }
    
    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }
    
    public SplitType getType() {
        return type;
    }
    
    public void setType(SplitType type) {
        this.type = type;
    }
    
    public List<Split> getSplits() {
        return splits;
    }
    
    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }
}
