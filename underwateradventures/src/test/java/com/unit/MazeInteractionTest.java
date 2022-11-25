package com.unit;

import com.Entity.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.group19.GameBoard;
import com.unit.GameboardTest;

public class MazeInteractionTest {
 
    Turtle turtleTest;
    Maze mazeTest = new Maze();
    KeyHandler keyTest;
    Scubadiver scubaTest;

    // test how a barrier and the turtle interact 
    @Test 
    public void testTurtleInteract()  throws IOException 
    {   
        GameboardTest nu  = new GameboardTest();
        GameBoard sharedTestBoard = nu.gbTest();
        keyTest = new KeyHandler(sharedTestBoard);
        mazeTest = new Maze();

        
        turtleTest = new Turtle(40, 560);
        Maze.mapGrid[1][15] = 'B';
        Maze.mapGrid[2][15] = 'B';
        Maze.mapGrid[3][15] = 'B';
        // there is a barrier at 40, 600
        keyTest.downPressed = true;

        //the turtle should not have moved down
        assertNotSame(600, turtleTest.getyPosition());    
    }


    // barrier + scuba 
    @Test
    public void testScubaInteract()  throws IOException 
    {
        Maze.mapGrid[1][13] = 'B';
        Maze.mapGrid[2][13] = 'B';
        Maze.mapGrid[3][13] = 'B';

        turtleTest = new Turtle(40, 560);
        scubaTest = new Scubadiver(40, 480);
        //  mazeTest = new Maze();
        scubaTest.update(turtleTest, mazeTest);
        // // //the scuba should not have moved down
        assertNotSame(520, scubaTest.getyPosition());    
    }

    // barrier + turtle + scuba (reach for same cell)

    
}
