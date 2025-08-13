package com.lalitbodana.sde.lld.snakeandladder.dto;

import java.util.Random;

public class Dice {
    private final Random random;
    private final int min;
    private final int max;
    
    public Dice(int min, int max) {
        this.random = new Random();
        this.min = min;
        this.max = max;
    }
    
    public int roll() {
        return random.nextInt(max - min + 1) + min;
    }
}
