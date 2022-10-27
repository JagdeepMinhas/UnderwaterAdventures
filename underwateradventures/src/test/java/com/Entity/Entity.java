package com.Entity;

public abstract class Entity {

    final int entitySize = 40; // size of each entity
    private int xPosition;
    private int yPosition;

    public int getyPosition() {
        return yPosition;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
