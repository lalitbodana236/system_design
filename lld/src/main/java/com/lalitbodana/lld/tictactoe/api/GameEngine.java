package com.lalitbodana.lld.tictactoe.api;

import com.lalitbodana.lld.tictactoe.board.TicTacToeBoard;
import com.lalitbodana.lld.tictactoe.game.Board;
import com.lalitbodana.lld.tictactoe.game.GameResult;
import com.lalitbodana.lld.tictactoe.game.Move;
import com.lalitbodana.lld.tictactoe.game.Player;

public class GameEngine {


    public Board start() {
        return new Board();
    }

    public void move(Board board, Player player, Move move) {

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
}

