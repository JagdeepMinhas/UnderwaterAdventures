package com.Entity;

import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.Math;
import java.util.*;

public class Scubadiver extends Entity  {
    
    int speed = entitySize;
    final static int UP = 0;
    final static int DOWN = 1;
    final static int LEFT = 2;
    final static int RIGHT = 3;
    final int min = 0;
    final int horizMax = 25;
    final int vertMax = 16;

    ArrayList < Integer > movesList = new ArrayList < Integer > ();
    
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
   
    public void update(Turtle t, Maze m){
        int turtleXPos = t.getxPosition();
        int turtleYPos = t.getyPosition();
        int diffY = Math.abs(turtleYPos - this.getyPosition());
        int diffX = Math.abs(turtleXPos - this.getxPosition());
   
        this.getValidMoves(m.getBarriers());
        if(diffX>diffY){
           
            for(int i=0; i < movesList.size(); i++){

                if(turtleXPos < this.getxPosition()){
                    if(movesList.get(i) == LEFT){
                        this.setxPosition(this.getxPosition()-speed);
                        movesList.clear();
                    }
                }
                
                else if(movesList.get(i) == RIGHT){
                    this.setxPosition(this.getxPosition()+speed);
                    movesList.clear();
                }
   
            }
        } 
        //Y distance less than X
        for(int i=0; i < movesList.size(); i++){

            if(turtleYPos < this.getyPosition()){
                if(movesList.get(i) == UP){
                    this.setyPosition(this.getyPosition()-speed);
                    movesList.clear();
                }
            }
            
            else if(movesList.get(i) == DOWN){
                this.setyPosition(this.getyPosition()+speed);
                movesList.clear();
            }

        }

    }

    void getValidMoves(char [][] b ){
       for(int i=0; i < 4; i++){
            if(this.isMoveValid(b, i)){
                movesList.add(i);
            }else{
                movesList.add(5);
            }
       }
    }

    boolean isMoveValid(char[][] b,int direction){
        
        if(direction == UP){
            int nextVertPos = this.getyPosition()/40 - 1;
            int nextHorizPos = this.getxPosition()/40;

            if(nextVertPos > min){
                if(b[nextVertPos][nextHorizPos] != 'B'){
                    if( b[nextVertPos][nextHorizPos] != 'C'){
                        return true;
                    }
                }
            }
        }
        if(direction == DOWN){
          int nextVertPos= this.getyPosition()/40 + 1;
          int nextHorizPos = this.getxPosition()/40;
          if(nextVertPos > min){
                if(b[nextVertPos][nextHorizPos] != 'B'){
                    if( b[nextVertPos][nextHorizPos] != 'C'){
                        return true;
                    }
                    }
            }
        }
        if(direction == RIGHT){
            int nextVertPos = this.getyPosition()/40;
            int nextHorizPos = this.getxPosition()/40 + 1;
            if(nextHorizPos < horizMax){
                if(b[nextVertPos][nextHorizPos] != 'B'){
                    if(b[nextVertPos][nextHorizPos] != 'C'){
                        return true;
                    }
                }

            }
        }

        if(direction == LEFT){
            int nextVertPos = this.getyPosition()/40;
            int nextHorizPos = this.getxPosition()/40 - 1;
            if(nextHorizPos > min){
                if(b[nextVertPos][nextHorizPos] != 'B'){
                  if(b[nextVertPos][nextHorizPos] != 'C'){
                        return true;
                  }
                }
            }


        }
        return false;
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
