package com.lalitbodana.lld.tictactoe.board;

import com.lalitbodana.lld.tictactoe.game.Board;

public class TicTacToeBoard extends Board {
    String[][] cell = new String[3][3];

    public String getCell(int i, int j) {
        return cell[i][j];
    }


}
