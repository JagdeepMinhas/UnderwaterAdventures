package com.group19;
import javax.swing.*;
import com.Entity.Turtle;
import com.Entity.Shark;
import com.Entity.KeyHandler;
import com.Entity.Maze;
import com.Entity.Scubadiver;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JPanel implements ActionListener{
    //cell size in characters (arbitrary)
    final int cellSize = 40;
    
    // 50x50 gameBoard
    final int maxCol = 25;
    final int maxRow = 20;
    final int screenWidth = maxCol * cellSize;
    final int screenHeight = maxRow * cellSize;

    // Gameloop Timer
    Timer gameTimer;

    KeyHandler key = new KeyHandler();

    // Shark Objects
    Shark s1;
    Shark s2;
    Turtle turtle;
    Scubadiver scuba ;
    Maze gameMaze;

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
         
          this.addKeyListener(key);
          this.setFocusable(true);
          gameTimer = new Timer(10, this);
          gameTimer.start();
      
         
          turtle= new Turtle();

          s1 = new Shark();
          s2 = new Shark(80,240);
          scuba = new Scubadiver();
          gameMaze = new Maze();
          
           
    }

    // Paint componenet method
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Image backgroundImage = myPicture.getScaledInstance(this.getWidth(), this.getHeight(),Image.SCALE_SMOOTH);
      g.drawImage(backgroundImage,0,0,null);
      Graphics2D g2 = (Graphics2D) g;
       
      turtle.draw(g2);
      
      
      s1.draw(g2);
      s2.draw(g2);
      scuba.draw(g2);
      gameMaze.draw(g2);
    }
    
    public void actionPerformed(ActionEvent e) {
       char [][] gameBarriers = gameMaze.getBarriers();

       final int min = 0;
       //based on example board
       final int horizMax = 20;
       final int vertMax = 8;
       

       if (key.upPressed==true){
            int nextVertPos = turtle.getyPosition()/40 - 1;
            int nextHorizPos = turtle.getxPosition()/40;

            if(nextVertPos > min){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                turtle.moveUp();
              }
          }
        }
    
        if (key.downPressed==true){

          int nextVertPos= turtle.getyPosition()/40 + 1;
          int nextHorizPos = turtle.getxPosition()/40;
            if(nextVertPos < vertMax){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                turtle.moveDown();
              }
            }
        }
       
        if (key.leftPressed==true){
          int nextVertPos = turtle.getyPosition()/40;
          int nextHorizPos = turtle.getxPosition()/40 - 1;
            if(nextHorizPos > min){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                turtle.moveLeft();
              }
            }
        }
        if (key.rightPressed==true){
          int nextVertPos = turtle.getyPosition()/40;
          int nextHorizPos = turtle.getxPosition()/40 + 1;

            if(nextHorizPos < horizMax){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                turtle.moveRight();
              }
            }
        }
        
  
      //Update Shark image
      
      s1.update();
      s2.update();
      repaint();
    }


    



}
