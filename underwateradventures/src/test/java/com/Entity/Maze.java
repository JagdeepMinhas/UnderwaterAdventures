package com.Entity;



import javax.imageio.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Maze extends Entity  {

    int tempX;
    int tempY;
    char [][] barriers;




    public Maze(Graphics2D g){
        this.setxPosition(0);
        this.setyPosition(0);
        try {
            setPerimeter(g);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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

    void setPerimeter(Graphics2D g) throws IOException{

        //for(int i =0; i < 800;i+=entitySize){
        //    tempX = i;
        //    tempY = 0;
        //    drawRock(g);
        //}

        File file = new File("Resources/MapGrid.txt");
        Scanner reader = new Scanner(file);
        String row;
        System.out.println("file opened; success!");
        for (int i = 0; i < 20; i++) {
            row = reader.nextLine();
            for (int j = 0; j < 20; j++) {
              this.barriers[i][j] = row.charAt(j);
            }
          }
          reader.close();
        


    }


    



}
