package com.Entity;

import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
* The Shark class (extends from Entity) 
* creates a Shark object and allows  
* the Shark to move in its assigned position. Also sets the bounds
* for Shark to be used to check collision with Turtle.
*
* @author         Tommy (Seahoun) Kim
* @version        1.0
* @since          2022-Oct
*/

public class Shark extends Entity {

    
    
    ArrayList < Integer > movesList = new ArrayList < Integer > ();

    // constructor for Shark class, parameters for setting position
    public Shark(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }

    // returns speed of Shark object
    public int getSpeed(){
        return this.speed;
    }

    
    // method for updating shark movement
    public void update(){
        this.setxPosition(this.getxPosition()+speed);
        if (this.getxPosition() > 680) {
            
            
            speed = -40;
        }

        if (this.getxPosition() < 400) {
            speed = 40;
        }
        
    }

    
    //method for getting bounds (collision handling)
    public Rectangle getBounds(){
        return new Rectangle(this.getxPosition(), this.getyPosition(), 40, 40);
    }

    //method for drawing shark image
    public void draw(Graphics2D g){
        BufferedImage sharkPic = null;
        try {
    
            sharkPic = ImageIO.read(new File("Resources/Images/Enemy/EnemyShark.png"));
        
           } catch (IOException ex) {
            System.err.println("Could not load image");
           }
        g.drawImage(sharkPic, this.getxPosition(), this.getyPosition(), 40, 40, null);
    }
    
}
