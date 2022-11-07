package com.group19;

import java.io.IOException;

import javax.swing.JFrame;

/**
 * Main method for testing Underwater Adventures Gameplay.
 */
public class App {

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
