package com.lalitbodana.lld.ds.graph;

public class SurroundedRegions {
    
    public static void main(String[] args) {
        char[][] board =
                {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'X', 'O', 'X'},
                        {'X', 'O', 'X', 'X'}};
        
        //  Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        new SurroundedRegions().solve(board);
    }
    
    private void print(char[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }
    
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int i = 0; i < rows; i++) {
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }
        
        print(board);
        
        for (int j = 0; j < cols; j++) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }
        print(board);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != 'O') {
            return;
        }
        
        grid[r][c] = '*';
        
        dfs(grid, r - 1, c); // up
        dfs(grid, r + 1, c); // down
        dfs(grid, r, c - 1); // left
        dfs(grid, r, c + 1); // right
    }
}
