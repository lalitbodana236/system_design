package com.lalitbodana.sde.pattern.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        String[][]  grid = {
                             {"1","1","1","1","0"},
                             {"1","1","0","1","0"},
                             {"1","1","0","0","0"},
                             {"0","0","0","0","0"}
        };
        
        numIslands(grid);
        
        
        String[][]   grid1 = {
        {"1","1","0","0","0"},
        {"1","1","0","0","0"},
        {"0","0","1","0","0"},
        {"0","0","0","1","1"}
    };
        numIslands(grid1);
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
