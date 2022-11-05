package com.group19;

import java.io.IOException;

import javax.swing.JFrame;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[]args) throws IOException{
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameBoard game = new GameBoard();
        window.add(game);
        window.setTitle("Underwater Adventure");
        window.pack();
        
        window.setVisible(true);
    }
}
