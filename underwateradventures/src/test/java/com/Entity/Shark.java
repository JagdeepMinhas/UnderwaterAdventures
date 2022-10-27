package com.Entity;

import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Shark extends Entity implements Movable {

  
    public Shark(){
        super();
        this.setxPosition(100);
        this.setyPosition(100);
    }

    public Shark(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
    }
    
    
    @Override
    public void move() {
        // TODO Auto-generated method stub
        
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
