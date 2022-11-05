package com.Rewards;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.*;
import javax.imageio.ImageIO;
import java.lang.Math;
import com.Entity.Entity;

public class RegualrRewards extends Entity {
    final int NO_Of_KEYS = 8;
    public int gridRow = 16;
    public int gridCol = 25;
    int x;
    int y;
    private static int count = 0;
    private char[][] grid = new char[gridRow][gridCol];

   public RegualrRewards() throws IOException {
        count = NO_Of_KEYS;
        readGrid();
        setKeys();
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
                    this.grid[i][j] = row.charAt(j);
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

    }

    public void drawKeys(Graphics2D g) {
        BufferedImage pic = null;
        try {
            pic = ImageIO.read(new File("Resources/Images/Reward/RewardKey.png"));

        } catch (IOException ex) {
            System.err.println("Could not load image");
        }
        
        g.drawImage(pic, this.getxPosition(), this.getyPosition(), 40, 40, null);
    }

    public void setKeys() throws IOException {
        int i = 0;
        while (i <= NO_Of_KEYS) {
            int randomRow = (int) (Math.random() * (gridRow));
            
            int randomCol = (int) (Math.random() * (gridCol));
           
            if (grid[randomRow][randomCol] == 'E') {
                grid[randomRow][randomCol] = 'K';
                i++;
            }
        }
        // updateGrid();

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
                    if (grid[i][j] == 'E') {
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
                if(grid[i][j]=='K'){
                    this.setxPosition(i*40);
                    this.setyPosition(j*40);

                    drawKeys(g);

                }
            }
        }
    }

}