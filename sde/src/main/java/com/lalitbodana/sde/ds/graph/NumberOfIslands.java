package com.lalitbodana.sde.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

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
    
    public static int numIslands(String[][] grid) {
        int row = grid.length;
        int col=grid[0].length;
        int count=0;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=="1"){
                    count++;
                    dfs(grid,i,j);
                    bfs(grid,i,j);
                    
                }
            }
        }
        
        System.out.println(count);
        
        return count;
    }
    
    public static void dfs(String[][] grid, int r, int c) {
        if(r<0 ||  c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!="1")
            return;
        
        grid[r][c]="0";
        
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid, r, c+1);
        dfs(grid,r,c-1);
    }
    
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    private static void bfs(String[][] grid ,int r ,int c){
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = "0";
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : directions) {
                int x = cell[0] + d[0], y = cell[1] + d[1];
                if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == "1") {
                    grid[x][y] = "0"; // mark visited
                    queue.add(new int[]{x, y});
                }
            }
        }
    }
}
