package com.group19;
import javax.swing.*;
import com.Entity.Turtle;
import com.Rewards.RegualrRewards;
import com.Entity.SharkController;
import com.Entity.KeyHandler;
import com.Entity.Maze;
import com.Entity.ScubaController;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
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
    final int maxRow = 25;
    final int screenWidth = maxCol * cellSize;
    final int screenHeight = maxRow * cellSize;

    Font gameOver;

    //Time
    public double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
  
    // Gameloop Timer
    Timer gameTimer;

    //Game State 
    public int gameState; 
    public final int titleState = 0;
    public final int playState = 1; 
    public final int pauseState = 2;
    public final int gameOverState = 6;

    public UI ui = new UI(this);
    public GameOverUI goUI = new GameOverUI(this);
    KeyHandler key = new KeyHandler(this);

    // Objects
    SharkController s;
    ScubaController sc;
    private RegualrRewards keys;
    
    public Turtle turtle = new Turtle(this);
    Maze gameMaze;

    // GameBoard constructor 
    BufferedImage myPicture =null;
    public GameBoard() throws IOException{
        Dimension boardDim = new Dimension(screenWidth, screenHeight);
        this.setPreferredSize(boardDim);  
        
        try{
          gameOver = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Font/Gameplay.ttf")).deriveFont(45F);
        } catch (IOException | FontFormatException e){
          e.printStackTrace();
        } 
        
        

        try{
          myPicture = ImageIO.read(new File("Resources/Images/GameBoard/GameBoardBckgd.png"));
          } catch (IOException ex) {
            System.err.println("Could not load image");
          }
         
          this.addKeyListener(key);
          this.setFocusable(true);
          gameTimer = new Timer(10, this);
          gameTimer.start();
      
         
          

          s = new SharkController();
          sc = new ScubaController();
          keys = new RegualrRewards();
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
        
      }
      else if(gameState == gameOverState){
        goUI.draw(g2);
        g.drawString("Time:"+dFormat.format(playTime), 40, 60 );  //Display final timer
        
        
      }
      else{
      
        Image backgroundImage = myPicture.getScaledInstance(this.getWidth(), this.getHeight(),Image.SCALE_SMOOTH);
        g.drawImage(backgroundImage,0,0,null);
        
        //Display timer going up
        playTime +=(double)1/60;
        g.setFont(gameOver);
        g.drawString("Time:"+dFormat.format(playTime), 40, 400 );
        
        turtle.draw(g2);
        
        
        s.draw(g2); //Shark
        sc.draw(g2);  //Scuba
        gameMaze.draw(g2);
        keys.draw(g2);
      }
    }
    
    public void restart(){
      turtle.setDefaultPositions(40, 560); //Reset Turtle position when restart game
      sc.setDefaultPositions(680, 80);
      playTime = 0; //Reset Timer to 0 when restart game
    }

    public void actionPerformed(ActionEvent e) {
      char [][] gameBarriers = gameMaze.getBarriers();
      
      final int min = 0;
       //based on example board
       final int horizMax = 25;
       final int vertMax = 16;
       

       if (key.upPressed==true){
            int nextVertPos = turtle.getyPosition()/40 - 1;
            int nextHorizPos = turtle.getxPosition()/40;

            if(nextVertPos > min){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){

                if( gameBarriers[nextVertPos][nextHorizPos] != 'C'){
                  turtle.moveUp();
                }

              }
          }
        }
    
        if (key.downPressed==true){

          int nextVertPos= turtle.getyPosition()/40 + 1;
          int nextHorizPos = turtle.getxPosition()/40;
            if(nextVertPos < vertMax){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                if( gameBarriers[nextVertPos][nextHorizPos] != 'C'){
                  turtle.moveDown();
                }
              }
            }
        }
       
        if (key.leftPressed==true){
          int nextVertPos = turtle.getyPosition()/40;
          int nextHorizPos = turtle.getxPosition()/40 - 1;
            if(nextHorizPos > min){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                if( gameBarriers[nextVertPos][nextHorizPos] != 'C'){
                  turtle.moveLeft();
                }
              }
            }
        }
        if (key.rightPressed==true){
          int nextVertPos = turtle.getyPosition()/40;
          int nextHorizPos = turtle.getxPosition()/40 + 1;

            if(nextHorizPos < horizMax){
              if(gameBarriers[nextVertPos][nextHorizPos] != 'B'){
                if( gameBarriers[nextVertPos][nextHorizPos] != 'C'){
                turtle.moveRight();
                }
              }
            }
        }
        
  
      //Update images
      
      turtle.update();
      s.update();
      sc.update(turtle,gameMaze);
      repaint();
    }

  

}
