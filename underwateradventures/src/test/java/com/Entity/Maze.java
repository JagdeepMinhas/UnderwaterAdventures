package com.Entity;



import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Maze extends Entity  {

    int tempX;
    int tempY;
    boolean [][] barrier;


    public Maze(Graphics2D g){
        this.setxPosition(0);
        this.setyPosition(0);
        setPerimeter(g);
    }

    void drawRock(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Barrier/BarrierRock2.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
 
        g.drawImage(pic, tempX, tempY,40,40, null);

    }

    void setPerimeter(Graphics2D g){

        for(int i =0; i < 600;i+=entitySize){
            tempX = i;
            tempY = 0;
            drawRock(g);
        }


    }


    



}
