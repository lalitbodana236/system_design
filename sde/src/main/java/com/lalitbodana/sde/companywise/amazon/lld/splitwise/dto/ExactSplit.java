package com.lalitbodana.sde.companywise.amazon.lld.splitwise.dto;

public class ExactSplit extends Split {
    public ExactSplit(String userId, int amount) {
        super(userId);
        this.amount = amount;
    }
}
