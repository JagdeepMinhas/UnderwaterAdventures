package com.Entity;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.*;

import java.awt.image.BufferedImage;

public class Turtle extends Entity  {


    int speed= entitySize; // turtle will move at most 4opx with every move
    
    private LinkedList<Shark> e = SharkController.getSharkBounds();
    private LinkedList<Scubadiver> a = ScubaController.getScubaBounds();


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

    
    //makes a Invisible Rectangle around entity to be used to check collision
    public Rectangle getBounds(){
        return new Rectangle(this.getxPosition(), this.getyPosition(), 40, 40);
    } 
    
    public void update(){
        SharkCollision();
        ScubaCollision();
    }


    //Shark Collision
    public void SharkCollision(){
        for (int i = 0; i<e.size(); i++){
            if(getBounds().intersects(e.get(i).getBounds())){       //if intersects with shark
                System.out.println("COLLISION");
                System.exit(0);                             //exit game (idk how to make gameOverBckgd to pop out);
            }
        }
    }

    public void ScubaCollision(){
        for (int i = 0; i<a.size(); i++){
            if(getBounds().intersects(a.get(i).getBounds())){       //if intersects with shark
                System.out.println("COLLISION");
                System.exit(0);                             //exit game (idk how to make gameOverBckgd to pop out);
            }
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
