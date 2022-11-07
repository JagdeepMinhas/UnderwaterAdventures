package com.Entity;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.*;

public class Squid extends Entity {

    char squidChar = 'Q';
    Maze maze = new Maze();
    int gridRow = 16;
    int gridCol = 25;
    int tempX;
    int tempY;
    public boolean touched;
    public long time_stamp = 0;

    public Squid(int x, int y){
        super();
        this.setxPosition(x);
        this.setyPosition(y);
        this.touched = false;
    }
    void setTouched(boolean value){
        this.touched = value;
    }


    void drawSquid(Graphics2D g){
    BufferedImage pic = null;
    try{
        pic = ImageIO.read(new File("Resources/Images/Punishment/PunishmentSquid.png"));
    } catch (IOException ex) {
        System.err.println("Could not load image");
    }
    
    g.drawImage(pic,tempX,tempY,40,40,null);
}

    void setSquid(Graphics2D g){
        for(int i=0; i<gridRow;i++){
            for(int j=0; j<gridCol; j++){
                if(maze.getMapGrid(i,j) == 'Q'){
                    tempX = j * entitySize;
                    tempY = i * entitySize;
                    drawSquid(g);
                }
            }
        }

    }


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
