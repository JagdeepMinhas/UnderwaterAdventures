package com.Rewards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.Entity.Entity;
import com.Entity.Maze;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
// import com.Entity.Barrier;

public class BonusRewards extends Entity {

    int tempX,tempY;
    final int NO_OF_SHRIMPS;
    final int NO_OF_WORMS;
    public int gridRow = 16;
    public int gridCol = 25;

    // private static int count;
    
    Maze maze = new Maze();

    public BonusRewards() throws IOException {
        NO_OF_SHRIMPS = 5;
        NO_OF_WORMS = 5;
        readGrid();
        setWorms();
    }

    public void readGrid() {
        String row;
        File file = new File("Resources/MapGrid.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);

            for (int i = 0; i < gridRow; i++) {
                row = sc.nextLine();
                for (int j = 0; j < gridCol; j++) {
                    maze.mapGrid[i][j] = row.charAt(j);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    public void drawWorms(Graphics2D g) {
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Reward/BonusRewardWorm.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic, tempX, tempY, 40, 40, null);
    }

    public void setWorms() throws IOException {
        int i = 0;
        while (i <= NO_OF_WORMS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
            if ((maze.mapGrid[randomRow][randomCol] == 'E')){
                maze.mapGrid[randomRow][randomCol] = 'K';
                i++;
            }
        }


    }

    public void updateGrid() throws IOException {

        File file = new File("Resources/MapGrid.txt");
        String row = "";
        Scanner sc;
        try {
            sc = new Scanner(file);
            FileWriter fw = new FileWriter(file, true);

            for (int i = 0; i < gridRow; i++) {
                row = sc.nextLine();
                for (int j = 0; j < gridCol; j++) {
                    if (maze.mapGrid[i][j] == 'E'){
                        StringBuilder temp = new StringBuilder(row);
                        temp.setCharAt(j, 'E');
                        String newString = temp.toString();
                    }
                }
            }

            fw.close();
            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g) {

        for (int i = 0; i < gridRow; i++) {
            for (int j = 0; j < gridCol; j++) {
                if(maze.mapGrid[i][j]=='K' ){
                    tempX = j * 40;
                    tempY = i * 40;

                    drawWorms(g);

                }
            }
        }
    }

}

