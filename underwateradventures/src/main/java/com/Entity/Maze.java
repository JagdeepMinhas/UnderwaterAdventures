package com.Entity;



import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* The Maze class (extends from Entity)
* keeps track of all moving
* and stationary entity positions on the Gameboard.
* Methods created to display the Maze on the JFrame
*
* @author  Hazelle Lebumfacil
* @collaborator Tommy Kim 
* @version 1.0
* @since   2022-Oct 
*/

public class Maze extends Entity  {
    BufferedImage rockImg = null;
    BufferedImage coralImg = null;
    BufferedImage seaweedImg  = null;
    BufferedImage exitGImage  = null;

    int tempX;
    int tempY;
    //integers based on current MapGrid
    public static int maxRow =16;
    public static int maxCol = 25;
    //public char [][] mapGrid = new char [maxRow][maxCol];
    public  static char [][] mapGrid = {
        {'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
        {'B','E','E','E','E','E','E','E','B','H','H','H','H','H','H','H','H','E','E','E','E','B','E','E','B'},
        {'B','E','E','B','B','E','E','S','E','E','E','B','E','E','E','B','E','E','C','E','E','E','E','E','B'},
        {'B','E','E','B','E','E','B','S','E','C','E','B','E','E','B','B','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','E','E','Q','B','S','E','E','E','B','E','E','B','E','E','E','E','B','B','B','B','B','B'},
        {'B','B','B','B','B','B','B','E','E','E','E','B','E','E','E','E','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','E','E','E','E','E','E','E','E','B','B','B','B','B','E','E','E','E','C','E','E','B','B'},
        {'B','E','E','B','E','E','S','E','B','E','E','B','E','E','E','E','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','B','B','E','S','B','B','E','E','B','E','E','E','B','B','B','B','B','E','E','C','E','B'},
        {'B','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','E','B'},
        {'B','E','E','B','E','E','C','E','E','E','E','E','E','B','B','B','B','B','E','E','E','C','E','S','B'},
        {'B','E','E','B','E','E','E','E','B','B','B','B','E','B','E','E','E','E','E','E','E','B','B','S','B'},
        {'B','E','E','B','B','E','E','S','B','E','E','E','E','B','E','E','C','E','B','B','B','B','Q','S','B'},
        {'B','E','E','B','E','E','E','S','B','E','S','S','S','S','E','E','E','E','B','E','E','E','E','E','B'},
        {'B','k','E','E','E','B','E','E','B','H','H','H','H','H','H','H','H','E','E','E','E','E','E','E','B'},
        {'B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B','B'},
    };

    
   
    

   

    

    //constructor for Maze Class
    public Maze() {
        this.setxPosition(0);
        this.setyPosition(0);
        getImages();
    }
    public void getImages(){
        try {
            rockImg = ImageIO.read(new File("Resources/Images/Barrier/BarrierRock2.png"));
            coralImg = ImageIO.read(new File("Resources/Images/Barrier/BarrierCoral.png"));
            seaweedImg = ImageIO.read(new File("Resources/Images/Punishment/PunishmentSeaweed.png"));
            exitGImage = ImageIO.read(new File("Resources/Images/ExitGate/NicePng_gate-png_613378.png"));
     
           } catch (IOException ex) {
             System.err.println("Could not load image");
           }

    }
    //method to draw Rock Image
    void drawRock(Graphics2D g){
       
        g.drawImage(rockImg, tempX, tempY,40,40, null);

    }

    //method to draw Coral Image 
    void drawCoral(Graphics2D g){
        
        g.drawImage(coralImg, tempX, tempY,40,40, null);

    }

    //method to draw Seaweed Image
    void drawSeaweed(Graphics2D g){
 
        g.drawImage(seaweedImg, tempX, tempY,40,40, null);

    }

    //Method to draw Exit Gate
    void drawExitGate(Graphics2D g){
        g.drawImage(exitGImage, tempX, tempY,40,40, null);

    }

    //Method that draws mapGrid array on jframe (handles logic)
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
                    if(mapGrid[i][j] == 'G'){
                        tempX = j * entitySize;
                        tempY = i * entitySize;
                        drawExitGate(g);
                    }
                    
                }
                
            }



        

        
    }


}
