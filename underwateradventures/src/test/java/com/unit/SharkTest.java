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
        //  GameBoard nu  = new GameBoard();

        turtleTest = new Turtle(40,40);
        sharkTest = new Shark(40,40);

        // if (turtleTest.getBounds().intersects(sharkTest.getBounds())){
        //     nu.gameState = nu.gameOverState;
        // }
         assertEquals(turtleTest.getBounds(), sharkTest.getBounds());
        //  assertEquals(nu.gameState, nu.gameOverState);
    }

    //Test Constructor for Shark and SharkController
    @Test
    public void setShark(){
        sharkTest = new Shark(40,40);

        assertEquals(sharkTest.getxPosition(), 40);
        assertEquals(sharkTest.getyPosition(), 40);
    }

    @Test
    public void testSetSharkController(){
        SharkController sharkContTest = new SharkController();
        Shark shark1 = SharkController.e.get(0);
        Shark shark2 = SharkController.e.get(1);

        assertEquals(shark1.getxPosition(), 40);
        assertEquals(shark1.getyPosition(), 40);

        assertEquals(shark2.getxPosition(), 220);
        assertEquals(shark2.getyPosition(), 560);
    }

    @Test
    public void testAddSharkToList(){
        SharkController sharkContTest = new SharkController();
        Shark shark3 = new Shark(80,80);
        sharkContTest.addShark(shark3);

        Shark checkShark = SharkController.e.get(2);
        assertEquals(checkShark.getxPosition(), 80);
        assertEquals(checkShark.getyPosition(), 80);
    }
    
    //Test getBounds()
    @Test 
    public void testgetBounds(){
        sharkTest = new Shark(80, 80);
        Rectangle rec = new Rectangle(80, 80, 40, 40);

        assertEquals(sharkTest.getBounds(), rec);

    }

    @Test
    public void testSharkSpeed(){
        sharkTest = new Shark(720, 40);
        sharkTest.update();

        // If xPosition of Shark is > 680, speed = -40. In this case, xPosition is 720 which is bigger than 680 so speed should be -40.
        assertEquals(sharkTest.getSpeed(), -40);

        sharkTest = new Shark(320, 40);
        sharkTest.update();

        // If xPosition of Shark is < 400, speed = 40. In this case, xPosition is 320 which is smaller than 400 so speed should be 40.
        assertEquals(sharkTest.getSpeed(), 40);
    }


}

