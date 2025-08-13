package com.lalitbodana.sde.lld.snakeandladder.dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;
    
    public Game(Board board, Dice dice, List<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(players);
    }
    
    public void start() {
        while (true) {
            Player currentPlayer = players.poll();
            int roll = dice.roll();
            int initialPosition = currentPlayer.getPosition();
            int finalPosition = initialPosition;
            
            if (initialPosition + roll <= board.getSize()) {
                finalPosition = initialPosition + roll;
                finalPosition = board.move(finalPosition);
            }
            
            currentPlayer.setPosition(finalPosition);
            System.out.println(currentPlayer.getName() + " rolled a " + roll +
                                       " and moved from " + initialPosition + " to " + finalPosition);
            
            if (finalPosition == board.getSize()) {
                System.out.println(currentPlayer.getName() + " wins the game");
                break;
            }
            
            players.offer(currentPlayer);
        }
    }
}
