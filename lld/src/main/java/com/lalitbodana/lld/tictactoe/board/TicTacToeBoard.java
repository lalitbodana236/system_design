package com.lalitbodana.lld.tictactoe.board;

import com.lalitbodana.lld.tictactoe.game.Board;
import com.lalitbodana.lld.tictactoe.game.Cell;

public class TicTacToeBoard extends Board {
    String[][] cells = new String[3][3];

    public String getCell(int i, int j) {
        return cells[i][j];
    }

    public void setCell(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()] = symbol;
    }


}
