package com.lalitbodana.sde.ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4; // Change this for different board sizes
        
        List<Integer> list = new ArrayList();
        list.stream().mapToInt(Integer::intValue).toArray();
        
        
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();

        nQueen(board, ans, 0, n);

        // Print solutions
        for (List<String> solution : ans) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static void nQueen(boolean[][] board, List<List<String>> ans, int row, int n) {
        if (row == n) { // Base case: If all queens are placed
            prepareAndStoreAns(board, ans, n);
            return;
        }


        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                nQueen(board, ans, row + 1, n);
                board[row][col] = false;
            }
        }


    }

    public static void prepareAndStoreAns(boolean[][] board, List<List<String>> ans, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < n; j++) {
                temp.append(board[i][j] ? "Q" : ".");
            }
            result.add(temp.toString());
        }
        ans.add(result);
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        //direction : 1
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        //direction : 2
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }

        //direction : 3
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
