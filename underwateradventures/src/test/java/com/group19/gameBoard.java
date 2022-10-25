package test.java.com.group19;

import javax.swing.*;
import javax.imageio.*;

import java.awt.Color;
import java.io.IOException;
import java.awt.*;
import java.awt.image.BufferedImage;




public class gameBoard extends JPanel{
    
    //cell size in characters (arbitrary)
    final int cellSize = 40;
    
    // 50x50 gameBoard
    final int maxCol = 50;
    final int maxRow = 50;
    final int screenWidth = maxCol * cellSize;
    final int screenHeight = maxRow * cellSize;

    private ImageIcon GameBoardBckgd;
    private JLabel GameBoardBckgdLabel;

    //GameBoard constructor 
    public gameBoard(){
        Dimension boardDim = new Dimension(screenWidth, screenHeight);
        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResource("/GameBoardBckgd.png"));
            GameBoardBckgd = new ImageIcon(img);
            GameBoardBckgdLabel = new JLabel(GameBoardBckgd);
            GameBoardBckgdLabel.setSize(boardDim);
          } catch (IOException ex) {
            System.err.println("Could not load image");
          }

        this.setPreferredSize(boardDim);
        this.setBackground(Color.BLUE);
    }



}