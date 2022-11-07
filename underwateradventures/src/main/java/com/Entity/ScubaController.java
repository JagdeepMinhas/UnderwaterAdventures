package com.Entity;
import java.awt.Graphics2D;
import java.util.LinkedList;

/**
* The Scuba Controller Class is the control center
* of the Scuba object. It makes a LinkedList of Scuba,
* and uses methods to place Scuba on the game board and
* maintain it
*
* @author    Tommy (Seahoun) Kim, Hazelle Lebumfacil
* @version   1.0
* @since     2022-Oct
*/

public class ScubaController extends Entity {
    static LinkedList<Scubadiver> a = new LinkedList<Scubadiver>();

    Scubadiver TempScuba;
    
     // constructor for ScubaController class
    public ScubaController(){
        addScuba(new Scubadiver(980,80));
    }

    // method to reset scuba position
    public void setDefaultPositions(int x, int y) {
        TempScuba.setDefaultPositions(680, 80);
    }

    // method for drawing all scuba images
    public void draw(Graphics2D g){
        for(int i = 0; i< a.size(); i++){
            TempScuba = a.get(i);

            TempScuba.draw(g);
        }
    }

    //method for updating all scuba objects
    public void update(Turtle t, Maze m){
        for (int i = 0; i < a.size(); i++){
            TempScuba = a.get(i);

            TempScuba.update(t,m);
        }
    }

     //method to add scuba to the array for maintaining number of scuba
    public void addScuba(Scubadiver scubadiver){
        a.add(scubadiver);
    }

    //method to return list that holds all scuba objects
    public static LinkedList<Scubadiver> getScubaBounds() {
        return a;
    }
}
