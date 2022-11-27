package com.unit;

import com.Entity.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.group19.GameBoard;
import com.unit.GameboardTest;

public class MazeInteractionTest {
 
    // test how a barrier and the turtle interact 
    @Test 
    public void testTurtleInteract()  throws IOException 
    {   
        Turtle turtleTest;
        KeyHandler keyTest;
        GameboardTest nu  = new GameboardTest();
        GameBoard sharedTestBoard = nu.gbTest();
        keyTest = new KeyHandler(sharedTestBoard);

        
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
        Maze mazeTest = new Maze();
        Maze.mapGrid[1][13] = 'B';
        Maze.mapGrid[2][13] = 'B';
        Maze.mapGrid[3][13] = 'B';
        // 13 * 40 = 520, barrier set there 

        Scubadiver scubaTest;
        Turtle turtleTest;

        turtleTest = new Turtle(40, 560);
        scubaTest = new Scubadiver(40, 480);

        scubaTest.update(turtleTest, mazeTest);
        // // //the scuba should not have moved down
        assertNotSame(520, scubaTest.getyPosition());    
    }

    //barrier changed, can a moving entity go through
    @Test
    public void testBarrierChangeTurtle()
    {
        Maze mazeTest = new Maze();
        Scubadiver scubaTest;
        Turtle turtleTest;

        turtleTest = new Turtle(40, 560);
        scubaTest = new Scubadiver(40, 480);

        Maze.mapGrid[1][13] = 'B';
        Maze.mapGrid[2][13] = 'B';
        Maze.mapGrid[3][13] = 'B';

        scubaTest.update(turtleTest, mazeTest);     
        assertNotSame(520, scubaTest.getyPosition()); 

        Maze.mapGrid[1][13] = 'E';
        Maze.mapGrid[2][13] = 'E';
        Maze.mapGrid[3][13] = 'E';
        // // //the scuba should be able to move down
        scubaTest.update(turtleTest, mazeTest);
        assertEquals(520, scubaTest.getyPosition());
    }

    //check that the coral also prevents an entity from moving
    @Test
    public void testCoralBarriers()
    {
        Maze mazeTest = new Maze();
        Scubadiver scubaTest;
        Turtle turtleTest;

        turtleTest = new Turtle(40, 560);
        scubaTest = new Scubadiver(40, 480);

        Maze.mapGrid[1][13] = 'C';
        Maze.mapGrid[2][13] = 'C';
        Maze.mapGrid[3][13] = 'C';

        scubaTest.update(turtleTest, mazeTest); 
        assertNotSame(520, scubaTest.getyPosition());
    }

    


    
}
