package com.Entity;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import java.awt.image.BufferedImage;

public class Turtle extends Entity  {


    int speed= entitySize; // turtle will move at most 4opx with every move
  
    public Turtle(){
        super();
        this.setxPosition(entitySize);   
        this.setyPosition(entitySize);
    }

    public Turtle(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }



   
   public void moveUp() {
       if (this.getyPosition()-speed<entitySize){
           return;
       }
       else{
           this.setyPosition(this.getyPosition()-speed);
       }    
    }

    public void moveDown() {
        if (this.getyPosition()+speed>(screenHeight-entitySize)){
            return;
        }
        else{
            this.setyPosition(this.getyPosition()+speed);
        }    
     }

     public void moveLeft() {
        if (this.getxPosition()+speed<entitySize){
            return;
        }
        else{
            this.setxPosition(this.getxPosition()-speed);
        }    
     }
     public void moveRight() {
        if (this.getxPosition()+speed>(screenWidth-entitySize)){
            return;
        }
        else{
            this.setxPosition(this.getxPosition()+speed);
        }    
     }

    public void draw(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Turtle/MCTurtle.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
        g.drawImage(pic, this.getxPosition(), this.getyPosition(),entitySize,entitySize, null);

    }

    
}
