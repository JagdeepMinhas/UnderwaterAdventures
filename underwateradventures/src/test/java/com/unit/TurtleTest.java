package com.unit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.Entity.Turtle;

import org.junit.jupiter.api.Test;
/**
 * Test Turtle class to test various method sof turtle class
 * @author Jagdeep Singh
 * @version 1.0
 * @since October 2022
 */

public class TurtleTest {

    // Method to test the default constructor
    @Test
    public void testConstructor(){
        Turtle turtle = new Turtle(40,40);
        assertEquals(40, turtle.getxPosition());
        assertEquals(40, turtle.getxPosition());
    }

    //Method to test move method of turtle
    @Test
    public void testTurtleMove(){
    
        Turtle turtle = new Turtle(120,120);
        turtle.moveUp();
        assertEquals(80,turtle.getyPosition()) ;
        assertEquals(120,turtle.getxPosition() );

        turtle.moveDown();
        assertEquals(120,turtle.getyPosition()) ;
        assertEquals(120,turtle.getxPosition() );

        turtle.moveLeft();
        assertEquals(120,turtle.getyPosition()) ;
        assertEquals(80,turtle.getxPosition() );
        
        turtle.moveRight();
        assertEquals(120,turtle.getyPosition()) ;
        assertEquals(120,turtle.getxPosition() );
        
    }
}


