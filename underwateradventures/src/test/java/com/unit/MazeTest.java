package com.unit;

import com.Entity.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

public class MazeTest {
    
    @Test
    public void testSetMaze()
    {
        Maze testMaze = new Maze();
        assertEquals(testMaze.getxPosition(), 0);
        assertEquals(testMaze.getyPosition(), 0);
        assertNotEquals(null, testMaze);
    }

    @Test
    public void testChangeMaze()
    {
        Maze testMaze = new Maze();
        testMaze.mapGrid[0][0] = 'E';
        assertEquals('E', testMaze.mapGrid[0][0]);
    }

 


}
