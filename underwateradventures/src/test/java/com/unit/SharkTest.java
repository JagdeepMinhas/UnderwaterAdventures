package com.unit;
import org.junit.jupiter.api.Test;

import com.Entity.Shark;
import com.Entity.SharkController;
import com.Entity.Turtle;
import com.group19.GameBoard;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.awt.*;


public class SharkTest {
    Turtle turtleTest;
    SharkController sTest;
    Shark sharkTest;

    //Test if turtle and shark bounds are equal, and if bounds are equal gameState becomes gameOverState
    @Test
    public void testSharkInteract() throws IOException {
        GameboardTest nu  = new GameboardTest();
        GameBoard sharedTestBoard = nu.gbTest();
        
        turtleTest = new Turtle(40,40);
        sharkTest = new Shark(40,40);

        if (turtleTest.getBounds().intersects(sharkTest.getBounds())){
            sharedTestBoard.gameState = sharedTestBoard.gameOverState;
        }
        assertEquals(turtleTest.getBounds(), sharkTest.getBounds());
       assertEquals(sharedTestBoard.gameState, sharedTestBoard.gameOverState);
    }

    //Test Constructor for Shark and SharkController
    @Test
    public void setShark(){
        sharkTest = new Shark(40,40);

        assertEquals(sharkTest.getxPosition(), 40);
        assertEquals(sharkTest.getyPosition(), 40);
    }
    
    //Test getBounds()
    @Test 
    public void testgetBounds(){
        sharkTest = new Shark(80, 80);
        Rectangle rec = new Rectangle(80, 80, 40, 40);

        assertEquals(sharkTest.getBounds(), rec);

    }
}

