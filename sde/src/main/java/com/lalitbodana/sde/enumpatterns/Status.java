package com.lalitbodana.sde.enumpatterns;

public enum Status {
    SUCCESS(200), ERROR(500), NOT_FOUND(404);
    
    private final int code;
    
    // Constructor
    Status(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
}
