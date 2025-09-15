package com.lalitbodana.sde;

public class WordSearch {
    
    public static void main(String[] args) {
        String[][]  board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String word = "ABCCED";
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        // Base case: if all characters are matched
        if (idx == word.length()) {
            return true;
        }
        
        // Boundary + mismatch check
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                    || board[i][j] != word.charAt(idx)) {
            return false;
        }
        
        // Mark visited
        char temp = board[i][j];
        board[i][j] = '#';
        
        // Explore neighbors (up, down, left, right)
        boolean found = dfs(board, word, i + 1, j, idx + 1) ||
                                dfs(board, word, i - 1, j, idx + 1) ||
                                dfs(board, word, i, j + 1, idx + 1) ||
                                dfs(board, word, i, j - 1, idx + 1);
        
        // Backtrack (restore)
        board[i][j] = temp;
        
        return found;
    }
}
