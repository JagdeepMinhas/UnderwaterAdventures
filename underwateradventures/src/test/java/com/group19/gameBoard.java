package com.group19;
import javax.swing.*;
import com.Entity.Turtle;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBoard extends JPanel{
    //cell size in characters (arbitrary)
    final int cellSize = 40;
    
    // 50x50 gameBoard
    final int maxCol = 50;
    final int maxRow = 50;
    final int screenWidth = maxCol * cellSize;
    final int screenHeight = maxRow * cellSize;


    //GameBoard constructor 
    BufferedImage myPicture =null;
    public GameBoard(){
        Dimension boardDim = new Dimension(screenWidth, screenHeight);
        this.setPreferredSize(boardDim);
 
        try {
           myPicture = ImageIO.read(new File("Resources/Images/GameBoard/GameBoardBckgd.png"));
          } catch (IOException ex) {
            System.err.println("Could not load image");
          }
           
    }

    // Paint componenet method
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Image dimg = myPicture.getScaledInstance(this.getWidth(), this.getHeight(),Image.SCALE_SMOOTH);
      g.drawImage(dimg,0,0,null);
      Graphics2D g2 = (Graphics2D) g;
      Turtle turtle= new Turtle(0,0);
      turtle.draw(g2);
      
      }
    


    



}
