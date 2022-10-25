package test.java.com.group19;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;


public class gameBoard extends JPanel{
    
    //cell size in characters (arbitrary)
    final int cellSize = 40;
    
    // 50x50 gameBoard
    final int maxCol = 50;
    final int maxRow = 50;
    final int screenWidth = maxCol * cellSize;
    final int screenHeight = maxRow * cellSize;

    //GameBoard constructor 
    public gameBoard(){
        this.setPreferredSize( new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLUE);
    }



}
