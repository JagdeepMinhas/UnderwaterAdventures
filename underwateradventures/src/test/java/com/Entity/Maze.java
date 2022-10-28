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
    char [][] barriers;




    public Maze(Graphics2D g) {
        this.setxPosition(0);
        this.setyPosition(0);
        setPerimeter(g);
    
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

    void setPerimeter(Graphics2D g) {

        /*for(int i =0; i < 800;i+=entitySize){
           tempX = i;
           tempY = 0;
           drawRock(g);
        }*/

        File file = new File("C:/Users/hazel/project/Resources/MapGrid.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            sc.close();
       
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
        

        
    }


}
