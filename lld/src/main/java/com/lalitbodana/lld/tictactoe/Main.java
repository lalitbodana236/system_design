package com.lalitbodana.lld.tictactoe;

public class Main {
    public static void main(String[] args) {

    }

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
                firstCharacter = board1.cell[i][0];
                for (int j = 1; j < 3; j++) {
                    if (!board1.cell[i][j].equals(firstCharacter)) {
                        rowComplete = false;
                        break;
                    }
                }
                if (rowComplete) break;
            }

            if (rowComplete) return new GameResult(true, firstCharacter);

            for (int i = 0; i < 3; i++) {
                colComplete = true;
                firstCharacter = board1.cell[0][i];
                for (int j = 1; j < 3; j++) {
                    if (!board1.cell[j][i].equals(firstCharacter)) {
                        colComplete = false;
                        break;
                    }
                }
                if (colComplete) break;
            }

            if (colComplete) return new GameResult(true, firstCharacter);

            for (int i = 0; i < 3; i++) {
                diagComplete = true;
                firstCharacter = board1.cell[0][0];
                if (!board1.cell[i][i].equals(firstCharacter)) {
                    diagComplete = false;
                    break;
                }
            }

            if (diagComplete) return new GameResult(true, firstCharacter);

            for (int i = 0; i < 3; i++) {
                revDiagComplete = true;
                firstCharacter = board1.cell[0][2];
                if (!board1.cell[i][2 - i].equals(firstCharacter)) {
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
                    if (board1.cell[i][j] != null) {
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

class Board {

}

class TicTacToeBoard extends Board {
    String[][] cell = new String[3][3];
}

class Player {

}

class Move {

}

class GameResult {
    boolean isOver;
    String winner;

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }
}