package com.lalitbodana.sde.tictactoe;

import com.lalitbodana.sde.tictactoe.api.GameEngine;
import com.lalitbodana.sde.tictactoe.game.Board;
import com.lalitbodana.sde.tictactoe.game.Cell;
import com.lalitbodana.sde.tictactoe.game.Move;
import com.lalitbodana.sde.tictactoe.game.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");

        //make moves;

        while (!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("O");
            Player opponent = new Player("X");
            System.out.println("Make your move!");

            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Move oppMove = new Move(new Cell(row, col));
            gameEngine.move(board, opponent, oppMove);

            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
            }
        }
        System.out.println("Game Result " + gameEngine.isComplete(board));

    }
}
