package com.lalitbodana.lld.ds.graph;

public class NumberOfIslands {
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int islands = 0;
        int rows = grid.length, cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') {
            return;
        }
        
        grid[r][c] = '0';
        
        dfs(grid, r - 1, c); // up
        dfs(grid, r + 1, c); // down
        dfs(grid, r, c - 1); // left
        dfs(grid, r, c + 1); // right
    }
}
