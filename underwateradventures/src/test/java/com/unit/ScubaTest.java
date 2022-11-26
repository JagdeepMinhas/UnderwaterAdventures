package com.unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import com.Entity.Maze;
import com.Entity.Scubadiver;
import com.Entity.Turtle;




public class ScubaTest {
    
    Maze maze = new Maze();
    
    
    
    //Constructor for Scubadiver and ScubaController
    @Test
    public void setScuba(){
        Scubadiver scubaTest = new Scubadiver(40, 40);

        assertEquals(scubaTest.getxPosition(), 40);
        assertEquals(scubaTest.getyPosition(), 40);
    }

    @Test
    public void testgetBounds(){
        Scubadiver scubaTest = new Scubadiver(120, 80);
        Rectangle rec = new Rectangle(120, 80, 40, 40);

        assertEquals(scubaTest.getBounds(), rec);
    }    

    @Test
    public void testDefaultPosition(){
        Scubadiver scubaTest = new Scubadiver(40,40);
        scubaTest.setDefaultPositions(240, 360);

        assertEquals(scubaTest.getxPosition(), 240);
        assertEquals(scubaTest.getyPosition(), 360);
    }

    @Test
    public void testScubaTrackTurtleUP(){
        Scubadiver scubaTest = new Scubadiver(80, 200);
        Turtle turtleTest = new Turtle(80,80);
        scubaTest.update(turtleTest, maze);
        //Expected: Turtle is above scuba so scuba will move UP. Next expected position of Scuba will be
        //          180 because the speed of Scuba is entitySize/2 = 20. 200 - 20 = 180.
        assertEquals(scubaTest.getyPosition(), 180);
    }

    @Test
    public void testScubaTrackTurtleDOWN(){
        Scubadiver scubaTest = new Scubadiver(80,80);
        Turtle turtleTest = new Turtle(80, 200);
        scubaTest.update(turtleTest, maze);
        //Expected: Turtle is below scuba so scuba will move DOWN. Next expected position of Scuba will be
        //          100 because the speed of Scuba is 20. 80 + 20 = 100.
        assertEquals(scubaTest.getyPosition(), 100);
    }

    @Test
    public void testScubaTrackTurtleLEFT(){
        Scubadiver scubaTest = new Scubadiver(980, 80);
        Turtle turtleTest = new Turtle(40, 560);
        scubaTest.update(turtleTest, maze);
        //Expected: Turtle is leftside of scuba so scuba will move LEFT. 
        //          Next expected position: 980 - 20 (20 is the speed of scuba).
        assertEquals(scubaTest.getxPosition(), 960);
    }

    @Test
    public void testScubaTrackTurtleRIGHT(){
        Scubadiver scubaTest = new Scubadiver(40, 560);
        Turtle turtleTest = new Turtle(980, 80);
        scubaTest.update(turtleTest, maze);
        //Expected: Turtle is rightside of scuba so scuba will move RIGHT.
        //          Next expected position: 40 + 20.
        assertEquals(scubaTest.getxPosition(), 60);
    }

    @Test
    public void testScubaSharkBoundInteract(){
        Maze.mapGrid[1][13] = 'H';
        Maze.mapGrid[2][13] = 'H';
        Maze.mapGrid[3][13] = 'H';
        
        Scubadiver scubaTest = new Scubadiver(40, 480);
        Turtle turtleTest = new Turtle(40,560);

        scubaTest.update(turtleTest, maze);

        //the scuba should not have moved down because H represents the Sharks path and scuba does not go through Sharks path
        assertNotEquals(520, scubaTest.getyPosition());
    }

    @Test
    public void testScubaMazeInteract(){
        Maze.mapGrid[1][13] = 'B';
        Maze.mapGrid[2][13] = 'B';
        Maze.mapGrid[3][13] = 'B';
        
        Scubadiver scubaTest = new Scubadiver(40, 480);
        Turtle turtleTest = new Turtle(40,560);

        scubaTest.update(turtleTest, maze);

        //the scuba should not have moved down because B represents barrier and scuba does not go through barriers
        assertNotEquals(520, scubaTest.getyPosition());

    }

}

