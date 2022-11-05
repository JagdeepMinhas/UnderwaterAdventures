package com.group19;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.FontFormatException;

public class GameOverUI {
    GameBoard gb; 
    Font gameOver, arial_40;
    public int commandNum = 0;
    

   
    public GameOverUI(GameBoard gb){
      this.gb = gb;

      try{
        gameOver = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Font/Gameplay.ttf")).deriveFont(45F);
      } catch (IOException | FontFormatException e){
        e.printStackTrace();
      } 
      
      arial_40 = new Font("Arial",Font.BOLD, 60);

    }

    public void draw (Graphics2D g){
      BufferedImage gameoverbckgd = null;
      if(gb.gameState == gb.gameOverState){
        try{
           gameoverbckgd = ImageIO.read(new File("Resources/Images/PrePostScreen/gameOverBckgd2.png"));
        }catch(IOException ex){
            System.err.println("Could not load image");
        }




        g.drawImage((gameoverbckgd.getScaledInstance(gb.getWidth(), gb.getHeight(), Image.SCALE_SMOOTH)), 0,0,null);
        
        g.setFont(gameOver);

        String text = "Play Again?";
        int x = (gb.screenWidth/2)-62;
        int y = (gb.screenHeight/2)+150;
        
        
        //Time
        
       
        //Menu 
        if(commandNum == 0){
          g.setFont(arial_40);
          g.setColor(Color.BLACK);
          g.drawString(">", x-50, y);
          g.setFont(gameOver);
          g.drawString(text,x-4,y-4);
          g.setColor(Color.BLACK);
          g.drawString(text, x-2, y-2);
          
        }
      }
    }
}
