
package com.Entity;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.group19.GameBoard;

/**
 * This class implements keylsitener interface to listen to the user key inputs
 * @author Jagdeep SINGH
 * @version 1.0
 * @since octobe 2022
 */
public class KeyHandler implements KeyListener{

    GameBoard gb;

    public boolean upPressed, downPressed,leftPressed, rightPressed,keyEnter;
    
    //constructor for keyhandler class
    public KeyHandler(GameBoard gb){
        this.gb = gb;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        

        if(gb.gameState == gb.titleState){

            if(keyCode == KeyEvent.VK_ENTER){
                gb.gameState = gb.playState;
            }
        }
        if(gb.gameState == gb.gameOverState){

            if(keyCode == KeyEvent.VK_ENTER){
                gb.gameState = gb.playState;
                gb.restart();
            }
        }
        if(gb.gameState == gb.gameWinState){

            if(keyCode == KeyEvent.VK_ENTER){
                gb.gameState = gb.playState;
                gb.restart();
            }
        }

        if(gb.gameState == gb.playState){

            if (keyCode == KeyEvent.VK_W){
                upPressed= true;
            }
            if (keyCode == KeyEvent.VK_S){
                downPressed=true;
            }
            if (keyCode == KeyEvent.VK_A){
                leftPressed=true;
            }
            if (keyCode == KeyEvent.VK_D){
                rightPressed=true;
            }

            if(keyCode == KeyEvent.VK_ENTER){
                keyEnter = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

       
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W){
            upPressed= false;
        }
        if (keyCode == KeyEvent.VK_S){
            downPressed=false;
        }
        if (keyCode == KeyEvent.VK_A){
            leftPressed=false;
        }

        if (keyCode == KeyEvent.VK_D){
            rightPressed=false;
        }

        if (keyCode == KeyEvent.VK_ENTER){
            keyEnter = false;
        }
    }
}

