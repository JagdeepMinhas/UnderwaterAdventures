package com.Entity;
import javax.imageio.*;

import com.group19.GameBoard;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.*;

import java.awt.image.BufferedImage;

/**  
* Turtle class extends entity and is the main character of the game
 * @author Jagdeep Singh
 * @version 1.0
 * @since October 2022
 */

public class Turtle extends Entity  {
    GameBoard gb;

    private int score;

    
    private LinkedList<Shark> e = SharkController.getSharkBounds();
    private LinkedList<Scubadiver> a = ScubaController.getScubaBounds();
    
    //constructor for turtle class
    public Turtle(GameBoard gb){
        super();
        this.score=0;
        this.setxPosition(entitySize);   
        this.setyPosition(560);
        this.gb = gb;
    }

    //method to get score attribute
    public int getScore() {
        return score;
    }

     //method to set score attribute
    public void setScore(int score) {
        this.score = score;
    }

     //method to reset score attribute
    public void resetScore(){
        this.score = 0;
    }

    //constructor for turtle class
    public Turtle(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }

    //method to set default start position for the turtle
    public void setDefaultPositions(int x, int y) {
        this.setxPosition(x);
        this.setyPosition(y);
    }
    
    //makes a Invisible Rectangle around entity to be used to check collision
    public Rectangle getBounds(){
        return new Rectangle(this.getxPosition(), this.getyPosition(), 40, 40);
    } 
    
    //method to update turtle with scuba or shark
    public void update(){
        SharkCollision();
        ScubaCollision();
    }


    //Method to implement Shark Collision functionality
    public void SharkCollision(){
        for (int i = 0; i<e.size(); i++){
            if(getBounds().intersects(e.get(i).getBounds())){       //if intersects with shark
                gb.gameState = gb.gameOverState;                            //Game Over Screen activated
            }
        }
    }

    //Method to implement scuba Collision functionality
    public void ScubaCollision(){
        for (int i = 0; i<a.size(); i++){
            if(getBounds().intersects(a.get(i).getBounds())){       //if intersects with scuba
                gb.gameState = gb.gameOverState;                       //Game Over Screen activated
            }
        }
    }

   //method to move turtle up based on W key 
   public void moveUp() {
       if (this.getyPosition()-speed<entitySize){
           return;
       }
       else{
           this.setyPosition(this.getyPosition()-speed);
       }    
    }

    //method to move turtle down based on S key 
    public void moveDown() {
        if (this.getyPosition()+speed>(screenHeight-entitySize)){
            return;
        }
        else{
            this.setyPosition(this.getyPosition()+speed);
        }    
     }

    //method to move turtle left based on A key
     public void moveLeft() {
        if (this.getxPosition()+speed<entitySize){
            return;
        }
        else{
            this.setxPosition(this.getxPosition()-speed);
        }    
     }
     //method to move turtle right based on D key
     public void moveRight() {
        if (this.getxPosition()+speed>(screenWidth-entitySize)){
            return;
        }
        else{
            this.setxPosition(this.getxPosition()+speed);
        }    
     }


    //method to draw turtle image
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
