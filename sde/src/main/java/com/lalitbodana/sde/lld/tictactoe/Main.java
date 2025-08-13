package com.lalitbodana.sde.lld.tictactoe;

import com.lalitbodana.sde.lld.tictactoe.dto.*;
import com.lalitbodana.sde.lld.tictactoe.service.GameEngine;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board(3);
        
        Player playerX = new Player("Player X", "X");
        Player playerO = new Player("Player O", "O");
        
        Player currentPlayer = playerX;
        
        while (true) {
            board.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") - Enter row and column (0-based): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            
            if (!board.placeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }
            
            GameResult result = board.checkGameResult();
            if (result != GameResult.IN_PROGRESS) {
                board.printBoard();
                switch (result) {
                    case PLAYER_X_WIN:
                        System.out.println("Player X wins!");
                        break;
                    case PLAYER_O_WIN:
                        System.out.println("Player O wins!");
                        break;
                    case DRAW:
                        System.out.println("It's a draw!");
                        break;
                }
                break;
            }
            
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
    }
    
}
