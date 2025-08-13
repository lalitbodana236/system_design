package com.lalitbodana.sde.lld.tictactoe.service;



import java.util.Scanner;

public class GameEngine {
 
    public boolean horizontal(char[][]grid,char val){
        System.out.println("checkout in row");
        boolean isRow=true;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){

                if(grid[i][j]!=val){
                    isRow=false;
                }
                if(!isRow) break;
            }
            if(isRow) return true;

        }

        return isRow;
    }

    public boolean vertical(char[][] grid,char val){
        System.out.println("checkout in column");
        boolean isCol=true;

        for(int i=0;i<3;i++){
            isCol=true;
            for(int j=0;j<3;j++){
                if(grid[j][i]!=val){
                    isCol=false;
                }
                if(!isCol) break;
            }
            if(isCol) return true;
        }
        return isCol;
    }


    public boolean daigonal(char[][] grid,char val){
        System.out.println("checkout in daigonal");
        boolean isDag=true;

        for(int i=0;i<3 ;i++){
            if(grid[i][i]!=val){
                isDag=false;
            }
            if(!isDag) break;

            if(isDag) return true;
        }
        return isDag;
    }

    public boolean antiDaigonal(char[][] grid,char val){
        System.out.println("checkout in antiDaigonal");
        boolean isAnitDag=true;

        for(int i=0;i<3;i++){
            if(grid[i][2-i]!=val){
                isAnitDag=false;
            }
            if(!isAnitDag) break;

            if(isAnitDag) return true;
        }
        return isAnitDag;
    }
    
   
}
