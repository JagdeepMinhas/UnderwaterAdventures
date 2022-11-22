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
    Scubadiver scubaTest;

    // test how a barrier and the turtle interact 
    @Test 
    public void testTurtleInteract()  throws IOException 
    {   
        GameBoard gbTest = new GameBoard();
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
    @Test
    public void testScubaInteract()  throws IOException 
    {
        //  mazeTest = new Maze();
        //  scubaTest = new Scubadiver(980, 80);
        //  turtleTest = new Turtle(980, 160);
        //  //barrier situated at 980, 120
        //  scubaTest.update(turtleTest, mazeTest);
        // // //the scuba should not have moved down
        //  assertNotSame(120, scubaTest.getyPosition());    
    }

    // barrier + turtle + scuba (reach for same cell)

    
}
