package com.Entity;

/**
 * Entity class that contains coordinates and entity size is extended by      all  the movable and stationary components
 * @author Jagdeep Singh
 * @version 1.0
 * @since October 2022
 */

public abstract class Entity {

    final int entitySize = 40; // size of each entity
    final int maxCol = 25;
    final int maxRow = 20;
    final int screenWidth = maxCol * entitySize;
    final int screenHeight = maxRow * entitySize;
    private  int xPosition;       
    private int yPosition;

    // getter to return yPosition attribute of any entity 
    public int getyPosition() {
        return yPosition;
    }

    // getter to return xPosition attribute of any entity 
    public int getxPosition() {
        return xPosition;
    }

    // setter to return xPosition attribute of any entity
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    // setter to return yPosition attribute of any entity
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
