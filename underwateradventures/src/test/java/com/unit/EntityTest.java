package com.unit;

import com.Entity.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;


public class EntityTest {

    @Test

    public void setxPositionTest()
    {
        //create entity and check
        Entity entityTest = new Turtle(40,40);
        assertEquals(40, entityTest.getxPosition());

        //change the x position
        entityTest.setxPosition(80);

        //check if change worked
        assertNotSame(40, entityTest.getxPosition());
        assertEquals(80, entityTest.getxPosition());
    }

    @Test
    public void setyPositionTest()
    {

                //create entity and check
                Entity entityTest = new Turtle(40,40);
                assertEquals(40, entityTest.getyPosition());
        
                //change the x position
                entityTest.setyPosition(80);
        
                //check if change worked
                assertNotSame(40, entityTest.getyPosition());
                assertEquals(80, entityTest.getyPosition());
    }


}
    