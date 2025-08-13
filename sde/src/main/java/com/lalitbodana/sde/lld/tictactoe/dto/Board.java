package com.lalitbodana.sde.lld.tictactoe.dto;

import java.util.UUID;

public class Board {
    private final int size;
    private final String[][] cells;
    
    public Board(int size) {
        this.size = size;
        this.cells = new String[size][size];
        initialize();
    }
    
    private void initialize() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = " ";
            }
        }
    }
    
    public boolean placeMove(int row, int col, String symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        if (!cells[row][col].equals(" ")) return false;
        cells[row][col] = symbol;
        return true;
    }
    
    public GameResult checkGameResult() {
        // Check rows
        for (int i = 0; i < size; i++) {
            if (!cells[i][0].equals(" ") && allEqual(cells[i])) {
                return cells[i][0].equals("X") ? GameResult.PLAYER_X_WIN : GameResult.PLAYER_O_WIN;
            }
        }
        
        // Check columns
        for (int j = 0; j < size; j++) {
            String first = cells[0][j];
            if (!first.equals(" ")) {
                boolean allSame = true;
                for (int i = 1; i < size; i++) {
                    if (!cells[i][j].equals(first)) {
                        allSame = false;
                        break;
                    }
                }
                if (allSame) {
                    return first.equals("X") ? GameResult.PLAYER_X_WIN : GameResult.PLAYER_O_WIN;
                }
            }
        }
        
        // Check main diagonal
        String firstDiag = cells[0][0];
        if (!firstDiag.equals(" ")) {
            boolean allSame = true;
            for (int i = 1; i < size; i++) {
                if (!cells[i][i].equals(firstDiag)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                return firstDiag.equals("X") ? GameResult.PLAYER_X_WIN : GameResult.PLAYER_O_WIN;
            }
        }
        
        // Check anti-diagonal
        String firstAnti = cells[0][size - 1];
        if (!firstAnti.equals(" ")) {
            boolean allSame = true;
            for (int i = 1; i < size; i++) {
                if (!cells[i][size - 1 - i].equals(firstAnti)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                return firstAnti.equals("X") ? GameResult.PLAYER_X_WIN : GameResult.PLAYER_O_WIN;
            }
        }
        
        // Check draw
        boolean boardFull = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (cells[i][j].equals(" ")) {
                    boardFull = false;
                    break;
                }
            }
        }
        if (boardFull) return GameResult.DRAW;
        
        return GameResult.IN_PROGRESS;
        
    }
    
    private boolean allEqual(String[] arr) {
        String first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals(first)) return false;
        }
        return true;
    }
    
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("--".repeat(size * 2));
            }
        }
        System.out.println();
    }
}
