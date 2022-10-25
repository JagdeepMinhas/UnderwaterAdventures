package com.group19;

import test.java.com.group19.gameBoard;

import javax.swing.JFrame;

/**
 * Unit test for simple App.
 */
class AppTest {

    public static void main(String[]args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameBoard game = new gameBoard();
        window.add(game);
        window.setTitle("Underwater Adventure");

        window.setVisible(true);
    }
}
