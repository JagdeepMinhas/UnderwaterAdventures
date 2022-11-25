package com.unit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import  org.junit.jupiter.api.Test;

import com.Entity.Maze;
import com.Rewards.BonusRewards;

public class BonusRewardTest {

    BonusRewards brTest = new BonusRewards();
    Maze mazeTest;

    //helper function to find the row of bonus reward 
    public int findReward_row(char[][] arr, int row, int col, char string){
        int row_ind = 0;
        for(int i=0 ; i< row; i++){
            for (int j=0; j<col; j++ ){
                if(arr[i][j] == string){
                    row_ind = i;
                }
            }
        }
        return row_ind;
    }

    //helper function to find the column of bonus reward 
    public int findReward_col(char[][] arr, int row, int col, char string){
        int col_ind = 0;
        for(int i=0 ; i< row; i++){
            for (int j=0; j<col; j++ ){
                if(arr[i][j] == string){
                    col_ind = j;
                }
            }
        }
        return col_ind;
    }

    @Test 
    public void setSWorms(){
        // brTest = new BonusRewards();
        brTest.setWorms();
        int wRow =  findReward_row(Maze.mapGrid, 16, 25, 'W');
        int wCol = findReward_col(Maze.mapGrid, 16, 25, 'W');

        assertEquals(Maze.mapGrid[wRow][wCol], 'W');
    }

    @Test 
    public void setShrimps(){

        brTest.setShrimps();
        int sRow =  findReward_row(Maze.mapGrid, 16, 25, 'X');
        int sCol = findReward_col(Maze.mapGrid, 16, 25, 'X');

        assertEquals(Maze.mapGrid[sRow][sCol], 'X');

    }
}
