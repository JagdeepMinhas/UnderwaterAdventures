package com.unit;

import com.Entity.*;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.group19.GameBoard;

public class MazeInteractionTest {
 
    Turtle turtleTest;
    Maze mazeTest;
    KeyHandler keyTest;
    GameBoard gbTest;

    // test how a barrier and the turtle interact 
    @Test 
    public void testTurtleInteract()  throws IOException 
    {
        gbTest = new GameBoard();
        keyTest = new KeyHandler(gbTest);
        mazeTest = new Maze();

        
        turtleTest = new Turtle(40, 560);
        // there is a barrier at 40, 600
        keyTest.downPressed = true;

        //the turtle should not have moved down
        assertNotSame(600, turtleTest.getyPosition());
        
    }


    // barrier + scuba 

    // barrier + turtle + scuba (reach for same cell)

    //
}
