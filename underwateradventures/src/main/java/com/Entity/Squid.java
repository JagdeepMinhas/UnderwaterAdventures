package com.Entity;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.*;

/**
* The Squid class (extends from Entity)
* Methods to display the squid and perform the 
* punishment functionality of the game.
*
* @author  Hazelle Lebumfacil
* @version 1.0
* @since   2022-Oct 
*/

public class Squid extends Entity {

    char squidChar = 'Q';
    Maze maze = new Maze();
    int gridRow = 16;
    int gridCol = 25;
    int tempX;
    int tempY;
    public boolean touched;
    public long time_stamp = 0;

    // constructor for Squid Class
    public Squid(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
        this.touched = false;
    }

    // method to change touched attribute for Squid
    void setTouched(boolean value){
        this.touched = value;
    }

    // method to display squid on JFrame
    void drawSquid(Graphics2D g){
        BufferedImage pic = null;
        try{
            pic = ImageIO.read(new File("Resources/Images/Punishment/PunishmentSquid.png"));
        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic,tempX,tempY,40,40,null);
    }

     //Method that draws squid based on mapGrid array on jframe (handles logic)
    void setSquid(Graphics2D g){
        for(int i=0; i<gridRow;i++){
            for(int j=0; j<gridCol; j++){
                if(Maze.mapGrid[i][j] == 'Q'){
                    tempX = j * entitySize;
                    tempY = i * entitySize;
                    drawSquid(g);
                }
            }
        }

    }

    // method to display punishment 
    void drawInk(Graphics2D g){
        Clock clock = Clock.systemDefaultZone();
        long inkTimeOn = clock.millis() - time_stamp;
    

        BufferedImage pic = null;
        try{
            pic = ImageIO.read(new File("Resources/Images/Punishment/PunishmentInkSplash.png"));
        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        if(inkTimeOn < 5000){
      
        boolean draw = g.drawImage(pic,200,40,800,800,null);
        this.touched = false;
        } else {
            time_stamp = clock.millis();
        }

    }




    






}
