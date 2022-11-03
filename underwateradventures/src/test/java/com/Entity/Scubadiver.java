package com.Entity;

import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Scubadiver extends Entity  {
    
    int gCost;      //the distance between the current cell and the start cell
    int hCost;      //distance from current cell to the goal cell
    int fCost;      //total cost of cell
    
    
    public Scubadiver(){
        super();
        this.setxPosition(200);
        this.setyPosition(200);
    }

    public Scubadiver(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(this.getxPosition(), this.getyPosition(), 40, 40);
    } 
   
    public void update(){
        
    }
    
    public void draw(Graphics2D g){
        BufferedImage scubadiverPic = null;
        try {
    
            scubadiverPic = ImageIO.read(new File("Resources/Images/Enemy/EnemyScubadiver.png"));
        
           } catch (IOException ex) {
            System.err.println("Could not load image");
           }
        g.drawImage(scubadiverPic, this.getxPosition(), this.getyPosition(), 40, 40, null);

    }
    
}
