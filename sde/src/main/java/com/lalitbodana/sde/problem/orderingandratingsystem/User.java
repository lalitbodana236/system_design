package com.lalitbodana.sde.problem.orderingandratingsystem;

public class User {
    private final String userId;
    private final String name;
    
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    
    public String getUserId() {
        return userId;
    }
}
