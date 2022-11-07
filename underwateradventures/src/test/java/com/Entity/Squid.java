package com.Entity;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Squid extends Entity {

    char squidChar = 'Q';
    Maze maze = new Maze();
    int gridRow = 16;
    int gridCol = 25;
    int tempX;
    int tempY;

    public Squid(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }

void drawSquid(Graphics2D g){
    BufferedImage pic = null;
    try{
        pic = ImageIO.read(new File("Resources/Images/Punishment/PunishmentSquid.png"));
    } catch (IOException ex) {
        System.err.println("Could not load image");
    }
    
    g.drawImage(pic,tempX,tempY,40,40,null);
}

    void setSquid(Graphics2D g){
        for(int i=0; i<gridRow;i++){
            for(int j=0; j<gridCol; j++){
                if(maze.getMapGrid(i,j) == 'Q'){
                    tempX = j * entitySize;
                    tempY = i * entitySize;
                    drawSquid(g);
                }
            }
        }

    }






}
