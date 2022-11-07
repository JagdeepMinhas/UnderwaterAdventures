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

    int interval = 4000; // every 4s
    int time_stamp = 0;
    
    
    Maze maze = new Maze();

    //Constructor
    public BonusRewards()  {
        setShrimps();
        setWorms();
    }

    //method for drawing worms 
    public void drawWorms(Graphics2D g) {
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Reward/BonusRewardWorm.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic, tempX, tempY, 40, 40, null);
    }

    //method for drawing shrimps
    public void drawShrimps(Graphics2D g) {
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Reward/BonusRewardShrimp.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic, tempX, tempY, 40, 40, null);
    }

    //method for setting worms on random Empty cells
    public void setWorms()  {
        int i = 0;
        while (i < NO_OF_WORMS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
            if ((maze.getMapGrid(randomRow, randomCol) == 'E')){
                maze.setMapGrid(randomRow, randomCol, 'W');
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
           
        
            if (maze.getMapGrid(randomRow, randomCol) == 'S'){
                maze.setMapGrid(randomRow, randomCol, 'X');
                i++;
            }
        }


    }



    //Method that draws Bonus Rewards on jframe (handles logic)
    public void draw(Graphics2D g) {

        int time_passed = (int) (System.currentTimeMillis() - time_stamp);

        boolean appear = true;
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(maze.getMapGrid(i, j) =='W' ){
                    tempX = j * 40;
                    tempY = i * 40;

                    drawWorms(g);

                }

                if (time_passed < interval && appear) {
                    if(maze.getMapGrid(i, j) == 'X' ){
                        tempX = j * 40;
                        tempY = i * 40;
                        // maze.draw(g);
                        drawShrimps(g);
                    }
                }
                else if (time_passed >= interval) {
                    time_stamp = (int) (System.currentTimeMillis());
                    appear = !appear;
                }
            }
        }
    }

}

