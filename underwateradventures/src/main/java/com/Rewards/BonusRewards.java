package com.Rewards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Entity.Entity;
import com.Entity.Maze;

/** * BonusRewards class  used to disply shrimps and Worms extends entity class
  * @author Carol and Jagdeep
 * @version 1.0
 * @since October 2022
 */

public class BonusRewards extends Entity {

    int tempX,tempY;
    final int NO_OF_SHRIMPS=5;
    final int NO_OF_WORMS=5;
    public int gridRow = 16;
    public int gridCol = 25;
    BufferedImage shrimpImg =null;
    BufferedImage worImage =null;

    long begin = 2000; 
    long end = 4000;
    long time_stamp = 0;
    boolean appear = true;
    
    Maze maze = new Maze();

    //Constructor
    public BonusRewards()  {
        setShrimps();
        setWorms();
        getImage();
    }

    public void getImage(){
        try {
            worImage = ImageIO.read(new File("Resources/Images/Reward/BonusRewardWorm.png"));
            shrimpImg  = ImageIO.read(new File("Resources/Images/Reward/BonusRewardShrimp.png"));


        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
    }

    //method for drawing worms 
    public void drawWorms(Graphics2D g) {
        g.drawImage(worImage, tempX, tempY, 40, 40, null);
    }

    //method for drawing shrimps
    public void drawShrimps(Graphics2D g) {
       
        g.drawImage(shrimpImg, tempX, tempY, 40, 40, null);
    }

    //method for setting worms on random Empty cells
    public void setWorms()  {
        int i = 0;
        while (i < NO_OF_WORMS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
            if ((Maze.mapGrid[randomRow][randomCol] == 'E')){
                Maze.mapGrid[randomRow][randomCol]='W';
                i++;
            }
        }


    }

    //method for setting worms on random Seaweed cells
    public void setShrimps() {
        int i = 0;
        while (i < NO_OF_SHRIMPS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
        
            if (Maze.mapGrid[randomRow][randomCol] == 'S'){
                Maze.mapGrid[randomRow][randomCol]= 'X';
                i++;
            }
        }


    }

    public boolean shrimp_appear(){
        if( appear == !appear){
            return false;
        }
        return true;
    }


    //Method that draws Bonus Rewards on jframe (handles logic)
    public void draw(Graphics2D g) {

        long time_passed = (long) (System.currentTimeMillis() - time_stamp);

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(Maze.mapGrid[i][j] =='W' ){
                    tempX = j * 40;
                    tempY = i * 40;

                    drawWorms(g);

                }

                if (begin < time_passed && time_passed < end && appear) {
                    if(Maze.mapGrid[i][j]  == 'X' ){
                        tempX = j * 40;
                        tempY = i * 40;

                        drawShrimps(g);
                    }
                }
                else if (time_passed >= end) {
                    time_stamp = (long) (System.currentTimeMillis());
                    appear = !appear;
                }
            }
        }
    }

}


