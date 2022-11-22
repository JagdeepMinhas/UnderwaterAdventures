package com.group19;

import javax.swing.*;
import com.Entity.Turtle;
import com.Rewards.BonusRewards;
import com.Rewards.RegualrRewards;
import com.Entity.SharkController;
import com.Entity.KeyHandler;
import com.Entity.Maze;
import com.Entity.ScubaController;
import com.Entity.SquidController;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Gameboard class
 * The main container for all components of the game,
 * creates Entity objects that populate the Gameboard
 *
 * @authors Hazelle Lebumfacil, Tommy (Seahoun) Kim,
 * @authors Jagdeep Singh, Carol Yu
 * @version 1.0
 * @since 2022-Oct
 */

public class GameBoard extends JPanel implements ActionListener {
  // cell size in characters (arbitrary)
  final int cellSize = 40;

  // 50x50 gameBoard
  final int maxCol = 25;
  final int maxRow = 25;
  final int screenWidth = maxCol * cellSize;
  final int screenHeight = maxRow * cellSize;

  Font gameOver;

  // Time
  public double playTime;
  DecimalFormat dFormat = new DecimalFormat("#0.00");

  // Gameloop Timer
  Timer gameTimer;

  // Game State
  public int gameState;
  public final int titleState = 0;
  public final int playState = 1;
  public final int gameOverState = 2;
  public final int gameWinState = 3;

  public UI ui = new UI(this);
  KeyHandler key = new KeyHandler(this);

  // Objects
  SharkController s;
  ScubaController sc;
  private RegualrRewards keys;
  private BonusRewards worms;
  public Turtle turtle = new Turtle(this);
  Maze gameMaze;
  SquidController squid;

  // GameBoard constructor

  public GameBoard() throws IOException {
    Dimension boardDim = new Dimension(screenWidth, screenHeight);
    this.setPreferredSize(boardDim);
    this.addKeyListener(key);
    this.setFocusable(true);
    gameTimer = new Timer(10, this);
    gameTimer.start();
    s = new SharkController();
    sc = new ScubaController();
    keys = new RegualrRewards();
    worms = new BonusRewards();
    gameMaze = new Maze();
    squid = new SquidController();
  }

  // method for setting up the game
  public void setupGame() {
    gameState = titleState;
  }

  // Paint componenet method
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    if (gameState == titleState) {
      ui.drawGameStart(g2);

    } else if (gameState == gameOverState) {
      ui.drawGameOver(g2);
      g.drawString("Time:" + dFormat.format(playTime), 40, 60); // Display final timer
      g.drawString("Score:" + turtle.getScore(), 40, 120);
    } else if (gameState == gameWinState) {
      ui.drawGameWin(g2);
      g.drawString("Time:" + dFormat.format(playTime), 40, 60); // Display final timer
      g.drawString("Score:" + turtle.getScore(), 40, 120);

    }

    else {
      BufferedImage myPicture = null;
      try {
        myPicture = ImageIO.read(new File("Resources/Images/GameBoard/GameBoardBckgd.png"));
      } catch (IOException ex) {
        System.err.println("Could not load image");
      }

      Image backgroundImage = myPicture.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
      g.drawImage(backgroundImage, 0, 0, null);

      // Display timer going up
      playTime += (double) 1 / 60;
      try {
        gameOver = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/Font/Gameplay.ttf")).deriveFont(45F);
      } catch (IOException | FontFormatException e) {
        e.printStackTrace();
      }
      g.setFont(gameOver);
      g.drawString("Time:" + dFormat.format(playTime), 0, 680);
      g.drawString("Score:" + turtle.getScore(), 300, 680);
      g.drawString("Keys:" + keys.getKeysCollected() + "/6", 600, 680);

      turtle.draw(g2);

      s.draw(g2); // Shark
      sc.draw(g2); // Scuba
      gameMaze.draw(g2);
      keys.draw(g2);
      worms.draw(g2);
      squid.draw(g2);
      squid.update(g2);
      g2.dispose();
    }
  }

  // method for resetting values once game restart
  public void restart() {
    turtle.setDefaultPositions(40, 560);
    sc.setDefaultPositions(680, 80);
    playTime = 0;
    keys.setKeysCollected(0);
    turtle.resetScore();
    Maze.mapGrid[1][22] = 'E';
    Maze.mapGrid[1][23] = 'E';
    worms.setWorms();
    keys.setKeys();
  }

  // method for gameloop updates
  public void actionPerformed(ActionEvent e) {

    moveTurtle();
    turtle.update();
    s.update();
    sc.update(turtle, gameMaze);
    repaint();
  }

  // method for turtle movement
  public void moveTurtle() {

    final int min = 0;
    // based on example board
    final int horizMax = 25;
    final int vertMax = 16;

    if (key.upPressed == true) {
      int nextVertPos = turtle.getyPosition() / 40 - 1;
      int nextHorizPos = turtle.getxPosition() / 40;
      int vertPos = turtle.getyPosition() / 40;
      int horizPos = turtle.getxPosition() / 40;

      if (nextVertPos > min) {
        if (Maze.mapGrid[nextVertPos][nextHorizPos] != 'B' && Maze.mapGrid[nextVertPos][nextHorizPos] != 'C') {
          if (Maze.mapGrid[vertPos][horizPos] == 'S' || Maze.mapGrid[nextVertPos][nextHorizPos] == 'S') {
            turtle.moveUp();
          } else {
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'W') {
              encounteredWorm();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveUp();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'X') {
              encounteredShrimp();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveUp();
            }
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'K') {
              encounteredKey();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              ;
              turtle.moveUp();

            }
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'Q') {
              encounteredSquid(nextVertPos);
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveUp();
            }
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'G') {
              gameState = gameWinState;
              turtle.moveUp();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'E' || Maze.mapGrid[nextVertPos][nextHorizPos] == 'H') {
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              ;
              turtle.moveUp();
            }
          }
        }
      }

    }

    if (key.downPressed == true) {

      int nextVertPos = turtle.getyPosition() / 40 + 1;
      int nextHorizPos = turtle.getxPosition() / 40;
      int vertPos = turtle.getyPosition() / 40;
      int horizPos = turtle.getxPosition() / 40;

      if (nextVertPos < vertMax) {
        if (Maze.mapGrid[nextVertPos][nextHorizPos] != 'B' && Maze.mapGrid[nextVertPos][nextHorizPos] != 'C') {
          if (Maze.mapGrid[vertPos][horizPos] == 'S' || Maze.mapGrid[nextVertPos][nextHorizPos] == 'S') {
            turtle.moveDown();
          } else {
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'W') {
              encounteredWorm();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveDown();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'X') {
              encounteredShrimp();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveUp();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'K') {
              encounteredKey();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveDown();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'Q') {
              encounteredSquid(nextVertPos);
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveDown();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'E' || Maze.mapGrid[nextVertPos][nextHorizPos] == 'H') {
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveDown();
            }
          }
        }
      }
    }

    if (key.leftPressed == true) {

      int nextVertPos = turtle.getyPosition() / 40;
      int nextHorizPos = turtle.getxPosition() / 40 - 1;
      int vertPos = turtle.getyPosition() / 40;
      int horizPos = turtle.getxPosition() / 40;

      if (nextHorizPos > min) {
        if (Maze.mapGrid[nextVertPos][nextHorizPos] != 'B' && Maze.mapGrid[nextVertPos][nextHorizPos] != 'C') {
          if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'S') {
            turtle.moveLeft();
          } else {
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'W') {
              encounteredWorm();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveLeft();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'X') {
              encounteredShrimp();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveUp();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'K') {
              encounteredKey();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveLeft();

            }
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'Q') {
              encounteredSquid(nextVertPos);
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveLeft();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'E' || Maze.mapGrid[nextVertPos][nextHorizPos] == 'H') {
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveLeft();
            }
          }
        }

      }
    }

    if (key.rightPressed == true) {
      int nextVertPos = turtle.getyPosition() / 40;
      int nextHorizPos = turtle.getxPosition() / 40 + 1;
      int vertPos = turtle.getyPosition() / 40;
      int horizPos = turtle.getxPosition() / 40;

      if (nextHorizPos < horizMax) {
        if (Maze.mapGrid[nextVertPos][nextHorizPos] != 'B' && Maze.mapGrid[nextVertPos][nextHorizPos] != 'C') {
          if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'S') {
            turtle.moveRight();
          } else {
            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'W') {
              encounteredWorm();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveRight();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'X') {
              encounteredShrimp();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveUp();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'K') {
              encounteredKey();
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveRight();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'Q') {
              encounteredSquid(nextVertPos);
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveRight();
            }

            if (Maze.mapGrid[nextVertPos][nextHorizPos] == 'E' || Maze.mapGrid[nextVertPos][nextHorizPos] == 'H') {
              updateMapGrid(nextVertPos, nextHorizPos, vertPos, horizPos);
              turtle.moveRight();
            }
          }
        }
      }
    }
  }

  public void updateMapGrid(int nextVertPos, int nextHorizPos, int vertPos, int horizPos) {

    Maze.mapGrid[nextVertPos][nextHorizPos] = 'T';
    Maze.mapGrid[vertPos][horizPos] = 'E';
  }

  public void encounteredWorm() {
    int tempScore = turtle.getScore() + 10;
    turtle.setScore(tempScore);
  }

  public void encounteredShrimp() {
    int tempScore = turtle.getScore() + 20;
    turtle.setScore(tempScore);
  }

  public void encounteredKey() {
    int temp = keys.getKeysCollected() + 1;
    keys.setKeysCollected(temp);
    int tempScore = turtle.getScore() + 20;
    turtle.setScore(tempScore);
    if (keys.getKeysCollected() == keys.getTotalKeys()) {
      drawExit();
    }
  }

  public void encounteredSquid(int coordinate) {
    int tempScore = turtle.getScore() - 20;
    turtle.setScore(tempScore);
    if (tempScore < 0) {
      gameState = gameOverState;
    }
    squid.squidTouched(true, coordinate * 40);

  }

  // method for drawing end cell when all keys are collected
  public void drawExit() {
    Maze.mapGrid[1][22] = 'G';
    Maze.mapGrid[1][22] = 'G';
  }

}
