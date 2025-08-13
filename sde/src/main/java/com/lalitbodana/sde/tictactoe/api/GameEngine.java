package com.lalitbodana.sde.tictactoe.api;

import com.lalitbodana.sde.tictactoe.board.TicTacToeBoard;
import com.lalitbodana.sde.tictactoe.game.*;

public class GameEngine {
    
    


    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void move(Board board, Player player, Move move) {
        if (board instanceof TicTacToeBoard board1) {
            board1.setCell(move.getCell(), player.symbol());
        } else {
            throw new IllegalArgumentException();
        }
    }

    public GameResult isComplete(Board board) {

        if (board instanceof TicTacToeBoard board1) {
            boolean rowComplete = true;
            boolean colComplete = true;
            boolean diagComplete = true;
            boolean revDiagComplete = true;
            String firstCharacter = "-";
            for (int i = 0; i < 3; i++) {
                rowComplete = true;
                firstCharacter = board1.getCell(i, 0);
                for (int j = 1; j < 3; j++) {
                    if (!board1.getCell(i, j).equals(firstCharacter)) {
                        rowComplete = false;
                        break;
                    }
                }
                if (rowComplete) break;
            }

            if (rowComplete) return new GameResult(true, firstCharacter);

            for (int i = 0; i < 3; i++) {
                colComplete = true;
                firstCharacter = board1.getCell(0, i);
                for (int j = 1; j < 3; j++) {
                    if (!board1.getCell(j, i).equals(firstCharacter)) {
                        colComplete = false;
                        break;
                    }
                }
                if (colComplete) break;
            }

            if (colComplete) return new GameResult(true, firstCharacter);

            for (int i = 0; i < 3; i++) {
                diagComplete = true;
                firstCharacter = board1.getCell(0, 0);
                if (!board1.getCell(i, i).equals(firstCharacter)) {
                    diagComplete = false;
                    break;
                }
            }

            if (diagComplete) return new GameResult(true, firstCharacter);

            for (int i = 0; i < 3; i++) {
                revDiagComplete = true;
                firstCharacter = board1.getCell(0, 2);
                if (!board1.getCell(i, 2 - i).equals(firstCharacter)) {
                    revDiagComplete = false;
                    break;
                }
            }

            if (revDiagComplete) {
                return new GameResult(true, firstCharacter);
            }

            int countOffFilledCells = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (board1.getCell(i, j) != null) {
                        countOffFilledCells++;
                    }
                }
            }

            if (countOffFilledCells == 9) {
                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }
        } else {
            return new GameResult(false, "-");
        }
    }

    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToeBoard board1) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }
            throw new IllegalArgumentException();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

