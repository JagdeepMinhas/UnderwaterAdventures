package com.Entity;

public abstract class Entity {

    final int entitySize = 40; // size of each entity
    public int xPosition;       // made public because idk how to make update() work if its in private
    public int yPosition;

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
