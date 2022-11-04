package com.Entity;

import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Shark extends Entity {

    int speed = entitySize; //shark  moves at most 40 px with every move

    public Shark(){
        super();
        this.setxPosition(40);
        this.setyPosition(80);
    }

    public Shark(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }
    
    public void update(){
       this.setxPosition(this.getxPosition()+speed);
        if (this.getxPosition() > 680) {
            speed = -40;
        }

        if (this.getxPosition() < 380) {
            speed = 40;
        }
    }
    
    public Rectangle getBounds(){
        return new Rectangle(this.getxPosition(), this.getyPosition(), 40, 40);
    }

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
