package com.unit;
import org.junit.jupiter.api.Test;

import java.io.IOException;

// import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.Entity.Maze;
import com.Entity.Turtle;
import com.Rewards.RegualrRewards;

public class RegularRewardTest {
    
    RegualrRewards keyTest;
    Turtle turtleTest;

    Maze mazeTest = new Maze();


    //helper function to find the row of worm 
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

    //helper function to find the col of worm 
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
    public void testSetWorms() throws IOException{


        keyTest = new RegualrRewards();
        keyTest.setKeys();
        int key_row = findReward_row(Maze.mapGrid, 16, 25, 'K');
        int key_col = findReward_col(Maze.mapGrid, 16, 25, 'K');
        
        assertEquals(Maze.mapGrid[key_row][key_col], 'K');

    }
}
