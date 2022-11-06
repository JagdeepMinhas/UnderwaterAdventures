package com.Rewards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Entity.Entity;
import com.Entity.Maze;

public class BonusRewards extends Entity {

    int tempX,tempY;
    final int NO_OF_SHRIMPS=5;
    final int NO_OF_WORMS=5;
    public int gridRow = 16;
    public int gridCol = 25;

    // private static int count;
    
    Maze maze = new Maze();

    public BonusRewards()  {
    
        setWorms();
    }

    

    public void drawWorms(Graphics2D g) {
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Reward/BonusRewardWorm.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic, tempX, tempY, 40, 40, null);
    }

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

   

    public void draw(Graphics2D g) {

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(maze.getMapGrid(i, j) =='W' ){
                    tempX = j * 40;
                    tempY = i * 40;

                    drawWorms(g);

                }
            }
        }
    }

}

