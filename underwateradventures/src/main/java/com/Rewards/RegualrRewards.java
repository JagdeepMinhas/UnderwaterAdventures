package com.Rewards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Entity.Entity;
import com.Entity.Maze;

/**
 * RegularRewards class  used to disply keys and it extends entity class    * @author  Jagdeep
 * @version 1.0
 * @since October 2022 
*/


public class RegualrRewards extends Entity {
    int tempX,tempY;
    private final int NO_Of_KEYS=6;
    public int gridRow = 16;
    public int gridCol = 25;
    private int keysCollected;
    BufferedImage keyImg =null;
    

    Maze maze = new Maze();

   //Constructor 
   public RegualrRewards(){
        keysCollected=0;
        setKeys();
        getImage();
    }

    public void getImage(){
       
        try {
            keyImg = ImageIO.read(new File("Resources/Images/Reward/RewardKey.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }

    }
    //method for returning private variable of total number of keys
    public int getTotalKeys(){
        return NO_Of_KEYS;
    }

    //method for returning how many keys collected
    public int getKeysCollected() {
    return keysCollected;
}

//method for setting number of key collected
public void setKeysCollected(int keysCollected) {
    this.keysCollected = keysCollected;
}

    //method for drawing keys
    public void drawKeys(Graphics2D g) {

        g.drawImage(keyImg, tempX, tempY, entitySize, entitySize, null);
    }

    //method for setting keys on random Empty cells
    public void setKeys()  {
        int i = 0;
        while (i < NO_Of_KEYS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
            if ((Maze.mapGrid[randomRow][randomCol]  == 'E')){
                Maze.mapGrid[randomRow][randomCol] ='K'; 
                i++;
            }
        }
    }

    public void keyCleanUp()
    {
        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(Maze.mapGrid[i][j]  =='K' ){
                    Maze.mapGrid[i][j] = 'E';
                }
            }
        }

    }

     
    //Method that draws keys on jframe (handles logic)
    public void draw(Graphics2D g) {

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(Maze.mapGrid[i][j]  =='K' ){
                    tempX = j * entitySize;
                    tempY = i * entitySize;
                    drawKeys(g);

                }
            }
        }
    }

}