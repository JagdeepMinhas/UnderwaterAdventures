package com.group19;

import javax.swing.JFrame;

/**
 * Unit test for simple App.
 */
class AppTest {

    public static void main(String[]args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameBoard game = new GameBoard();
        window.add(game);
        window.setTitle("Underwater Adventure");
        window.pack();
        
        window.setVisible(true);
    }
}
