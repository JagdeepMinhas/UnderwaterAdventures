package com.Entity;



import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Turtle extends Entity implements Movable {
    public Turtle(){
        super();
        this.setxPosition(0);   
        this.setyPosition(0);
    }

    public Turtle(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }


    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }
    public void draw(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Turtle/MCTurtle.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
        g.drawImage(pic, this.getxPosition(), this.getyPosition(),40,40, null);

    }
    
}
