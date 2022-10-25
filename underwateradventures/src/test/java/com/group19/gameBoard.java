package test.java.com.group19;

import javax.swing.*;

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

    private ImageIcon GameBoardBckgd;
    private JLabel GameBoardBckgdLabel;

    //GameBoard constructor 
    public gameBoard(){
        Dimension boardDim = new Dimension(screenWidth, screenHeight);
        GameBoardBckgd = new ImageIcon(this.getClass.getResource("project/Resources/Images/GameBoard"));
        GameBoardBckgdLabel = new JLabel(GameBoardBckgd);
        GameBoardBckgdLabel.setSize(boardDim);


        this.setPreferredSize(boardDim);
        this.setBackground(Color.BLUE);
    }



}
