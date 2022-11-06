package com.Entity;



import javax.imageio.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Maze extends Entity  {

    int tempX;
    int tempY;
    //integers based on current MapGrid
    static int maxRow =16;
    static int maxCol = 25;
    //public char [][] mapGrid = new char [maxRow][maxCol];
    public char [][] mapGrid = {
        {'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
        {'B','E','E','E','E','E','E','E','E','H','H','H','H','H','H','H','H','E','E','E','E','E','E','E','B'},
        {'B','E','E','B','B','E','E','S','E','E','E','B','E','E','E','B','E','E','C','E','E','E','E','E','B'},
        {'B','E','E','B','E','E','B','S','E','C','E','B','E','E','B','B','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','E','E','E','B','S','E','E','E','B','E','E','B','E','E','E','E','B','B','B','B','B','B'},
        {'B','B','B','B','B','B','B','E','E','E','E','B','E','E','E','E','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','E','E','E','E','E','E','E','E','B','B','B','B','B','E','E','E','E','C','E','E','B','B'},
        {'B','E','E','B','E','E','S','E','B','E','E','B','E','E','E','E','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','B','B','E','S','B','B','E','E','B','E','E','E','B','B','B','B','B','E','E','C','E','B'},
        {'B','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','B','E','E','C','E','E','E','E','E','E','B','B','B','B','B','E','E','E','C','E','S','B'},
        {'B','E','E','B','E','E','E','E','B','B','B','B','E','B','E','E','E','E','E','E','E','B','B','S','B'},
        {'B','E','E','B','B','E','E','S','B','E','E','E','E','B','E','E','C','E','B','B','B','B','E','S','B'},
        {'B','E','E','B','E','E','E','S','B','E','S','S','S','S','E','E','E','E','B','E','E','E','E','E','B'},
        {'B','E','E','E','E','B','E','E','B','H','H','H','H','H','H','H','H','E','E','E','E','E','E','E','B'},
        {'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
    };

    

    public char [][] getBarriers(){
        return mapGrid;
    }

    public char getMapGrid(int x, int y){
        return mapGrid[x][y];
    }

    public void setMapGrid(int x, int y, char value){
        mapGrid[x][y] = value;
    }


    public Maze() {
        this.setxPosition(0);
        this.setyPosition(0);
    }

    void drawRock(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Barrier/BarrierRock2.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
 
        g.drawImage(pic, tempX, tempY,40,40, null);

    }

    void drawCoral(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Barrier/BarrierCoral.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
 
        g.drawImage(pic, tempX, tempY,40,40, null);

    }

    void drawSeaweed(Graphics2D g){
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Punishment/PunishmentSeaweed.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }
 
        g.drawImage(pic, tempX, tempY,40,40, null);

    }


    public void draw(Graphics2D g) {

        

            for(int i=0; i<maxRow;i++){
                for(int j=0; j<maxCol; j++){
                    if(mapGrid[i][j] == 'B'){
                        tempX = j * entitySize;
                        tempY = i * entitySize;
                        drawRock(g);
                    }
                    if(mapGrid[i][j] == 'C'){
                        tempX = j * entitySize;
                        tempY = i * entitySize;
                        drawCoral(g);
                    }
                    if(mapGrid[i][j] == 'S'){
                        tempX = j * entitySize;
                        tempY = i * entitySize;
                        drawSeaweed(g);
                    }
                }
                
            }



        

        
    }


}
