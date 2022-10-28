package com.Entity;



import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Maze extends Entity  {



    public Maze(Graphics2D g){
        drawRock(g);
    }

    public void drawRock(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Barrier/BarrierRock2.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
        g.drawImage(pic, this.getxPosition(), this.getyPosition(),40,40, null);

    }
    



}
