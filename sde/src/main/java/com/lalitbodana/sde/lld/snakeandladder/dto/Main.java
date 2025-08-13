package com.lalitbodana.sde.lld.snakeandladder.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read minimal inputs (board size, counts, players). Positions are generated programmatically.
        System.out.println("Enter the Board Size");
        int boardSize = sc.nextInt();   // e.g., 100
        
        System.out.println("Enter the Number of Snake");
        int numSnakes = sc.nextInt();   // e.g., 9
        
        System.out.println("Enter the Number of Ladder");
        int numLadders = sc.nextInt();  // e.g., 8
        
        System.out.println("Enter the Number of Player");
        int numPlayers = sc.nextInt();  // e.g., 2
        
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Enter the Player "+ (i +1)+" Name ");
            players.add(new Player(sc.next()));
        }
        
        // Programmatically generate board with snakes & ladders
        Board board = Board.generate(boardSize, numSnakes, numLadders);
        
        // (Optional) print generated layout for debugging
        board.printLayout();
        
        // Two dice, 6 faces each
        Dice dice = new Dice(1, 6);
        
        // Start game
        Game game = new Game(board, dice, players);
        game.start();
    }
    
}
