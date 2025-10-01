package com.lalitbodana.sde.designpattern.practice.dto;

import java.util.*;

public class Board {
    private final int size;
    private final Map<Integer, Integer> snakesMap;
    private final Map<Integer, Integer> laddersMap;
    
    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.snakesMap = new HashMap<>();
        this.laddersMap = new HashMap<>();
        for (Snake snake : snakes) {
            snakesMap.put(snake.getHead(), snake.getTail());
        }
        for (Ladder ladder : ladders) {
            laddersMap.put(ladder.getStart(), ladder.getEnd());
        }
    }
    
    public int move(int position) {
        while (true) {
            if (snakesMap.containsKey(position)) {
                position = snakesMap.get(position);
            } else if (laddersMap.containsKey(position)) {
                position = laddersMap.get(position);
            } else {
                break;
            }
        }
        return position;
    }
    
    public int getSize() {
        return size;
    }
    
    
    public static Board generate(int size, int numSnakes, int numLadders) {
        if (size < 10) throw new IllegalArgumentException("Board size too small");
        Random random = new Random();
        
        Set<Integer> usedStarts = new HashSet<>(); // snake heads + ladder starts must be unique per constraints
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        
        // Generate snakes
        int attempts = 0;
        while (snakes.size() < numSnakes && attempts < numSnakes * 50) {
            attempts++;
            int head = 2 + random.nextInt(size - 2); // 2..size-1
            if (head == size) continue; // no snake at final cell
            if (usedStarts.contains(head)) continue;
            
            int tail = 1 + random.nextInt(head - 1); // 1..head-1
            if (tail == head) continue;
            
            // Light sanity: avoid super tiny snakes (optional)
            if (head - tail < Math.max(2, size / 25)) continue;
            
            snakes.add(new Snake(head, tail));
            usedStarts.add(head);
        }
        
        // Generate ladders
        attempts = 0;
        while (ladders.size() < numLadders && attempts < numLadders * 50) {
            attempts++;
            int start = 1 + random.nextInt(size - 2); // 1..size-2
            if (usedStarts.contains(start)) continue;
            
            int end = start + 1 + random.nextInt(size - start - 0); // > start up to size
            if (end <= start) continue;
            
            // Light sanity: avoid super tiny ladders (optional)
            if (end - start < Math.max(2, size / 25)) continue;
            
            ladders.add(new Ladder(start, end));
            usedStarts.add(start);
        }
        
        // If generation failed to hit requested counts (edge constraints), proceed with what we got.
        return new Board(size, snakes, ladders);
    }
    
    
    public void printLayout() {
        System.out.println("Snakes (head -> tail): " + snakesMap);
        System.out.println("Ladders (start -> end): " + laddersMap);
    }
    
    public static Board generate2(int size, int numSnakes, int numLadders) {
        Random random = new Random();
       // Map<Integer, Integer> snakes = new HashMap<>();
        //Map<Integer, Integer> ladders = new HashMap<>();
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        
        // Generate snakes
        for (int i = 0; i < numSnakes; i++) {
            int head = random.nextInt(size - 2) + 2; // 2..size-1
            int tail = random.nextInt(head - 1) + 1; // 1..head-1
           // snakes.put(head, tail);
            snakes.add(new Snake(head, tail));
        }
        
        // Generate ladders
        for (int i = 0; i < numLadders; i++) {
            int start = random.nextInt(size - 2) + 1; // 1..size-2
            int end = random.nextInt(size - start) + start + 1; // > start
           // ladders.put(start, end);
            ladders.add(new Ladder(start, end));
        }
        
        return new Board(size, snakes, ladders);
    }
    
    
    
    
}
