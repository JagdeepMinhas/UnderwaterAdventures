package com.Rewards;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.Entity.Entity;
import com.Entity.Maze;
// import com.Entity.Barrier;

public class RegualrRewards extends Entity {
    int tempX,tempY;
    private final int NO_Of_KEYS=6;
    public int gridRow = 16;
    public int gridCol = 25;
    private int keysCollected;
    

    Maze maze = new Maze();


   public RegualrRewards(){
        keysCollected=0;
        setKeys();
    }

    public int getTotalKeys(){
        return NO_Of_KEYS;
    }
    public int getKeysCollected() {
    return keysCollected;
}


public void setKeysCollected(int keysCollected) {
    this.keysCollected = keysCollected;
}

    public void drawKeys(Graphics2D g) {
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Reward/RewardKey.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic, tempX, tempY, 40, 40, null);
    }

    public void setKeys()  {
        int i = 0;
        while (i < NO_Of_KEYS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
            if ((maze.getMapGrid(randomRow,randomCol) == 'E')){
                maze.setMapGrid(randomRow, randomCol, 'K'); 
                i++;
            }
        }


    }

     

    public void draw(Graphics2D g) {

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(maze.getMapGrid(i, j) =='K' ){
                    tempX = j * 40;
                    tempY = i * 40;
                    drawKeys(g);

                }
            }
        }
    }

}