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
    static int maxRow =8;
    static int maxCol = 20;
    char [][] barriers = new char [8][20];

    public char [][] getBarriers(){
        return barriers;
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

    void setBarriers(){
        String row;
        File file = new File("Resources/MapGrid.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
           
                for(int i=0; i <maxRow; i++){
                    row = sc.nextLine();
                    for(int j=0; j< maxCol; j++){
                        this.barriers[i][j] = row.charAt(j);
                    }
                }
            sc.close();

        } catch (FileNotFoundException e) {
           
            e.printStackTrace();
        }

    }


    public void draw(Graphics2D g) {

        setBarriers();

            for(int i=0; i<maxRow;i++){
                for(int j=0; j<maxCol; j++){
                    if(barriers[i][j] == 'B'){
                        tempX = j * entitySize;
                        tempY = i * entitySize;
                        drawRock(g);
                    }
                }
                
            }



        

        
    }


}
