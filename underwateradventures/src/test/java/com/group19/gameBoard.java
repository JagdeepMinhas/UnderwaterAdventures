package com.group19;
import javax.swing.*;
import com.Entity.Turtle;
import com.Entity.Shark;
import com.Entity.SharkController;
import com.Entity.KeyHandler;
import com.Entity.Maze;
import com.Entity.ScubaController;
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

    //Game State 
    public int gameState; 
    public final int titleState = 0;
    public final int playState = 1; 
    public final int pauseState = 2;

    public UI ui = new UI(this);
    KeyHandler key = new KeyHandler(this);

    // Shark Objects
    SharkController s;
    ScubaController sc;
    Turtle turtle;
    Scubadiver scuba;
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

          s = new SharkController();
          sc = new ScubaController();
          
          gameMaze = new Maze();
           
    }

    public void setupGame(){
      gameState = titleState;
    }

    // Paint componenet method
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      if(gameState == titleState){
        ui.draw(g2);
      }else{
      
        Image backgroundImage = myPicture.getScaledInstance(this.getWidth(), this.getHeight(),Image.SCALE_SMOOTH);
        g.drawImage(backgroundImage,0,0,null);
        
        
        turtle.draw(g2);
        
        
        s.draw(g2); //Shark
        sc.draw(g2);  //Scuba
        gameMaze.draw(g2);
      }
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
        
  
      //Update images
      
      turtle.update();
      s.update();
      sc.update();
      repaint();
    }


    



}
