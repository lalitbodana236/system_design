package com.lalitbodana.sde.grind169;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(oranges(grid));
        
        int[][] grid1 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(oranges(grid1));
    }
    
    public static int oranges(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minutes = 0;
        
        while (true) {
            boolean changed = false;
            int[][] temp = new int[rows][cols];
            
            // Copy the current grid to temp
            for (int i = 0; i < rows; i++) {
                System.arraycopy(grid[i], 0, temp[i], 0, cols);
            }
            
            // Spread the rot
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            temp[i - 1][j] = 2;
                            changed = true;
                        }
                        if (i < rows - 1 && grid[i + 1][j] == 1) {
                            temp[i + 1][j] = 2;
                            changed = true;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            temp[i][j - 1] = 2;
                            changed = true;
                        }
                        if (j < cols - 1 && grid[i][j + 1] == 1) {
                            temp[i][j + 1] = 2;
                            changed = true;
                        }
                    }
                }
            }
            
            if (!changed) {
                break; // No more infection possible
            }
            
            grid = temp; // Update grid
            minutes++;
        }
        
        // Final Check: If any fresh oranges remain
        for (int[] row : grid) {
            for (int orange : row) {
                if (orange == 1) {
                    return -1;
                }
            }
        }
        
        return minutes;
    }
    
    
    public static int dummy(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty() && fresh > 0) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            minutes++;
            
            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];
                
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 1) {
                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX, newY});
                    fresh--;
                }
            }
            
            
        }
        
        return fresh == 0 ? minutes : -1;
    }
    
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Add all rotten oranges to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            minutes++;
            
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1];
                
                for (int[] dir : directions) {
                    int newX = x + dir[0], newY = y + dir[1];
                    
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                                && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                        fresh--;
                    }
                }
            }
        }
        
        return fresh == 0 ? minutes : -1;
    }
    
    private static void print(int[][] grid) {
        System.out.println("***");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
