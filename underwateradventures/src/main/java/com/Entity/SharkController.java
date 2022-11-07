package com.Entity;
import java.awt.Graphics2D;
import java.util.LinkedList;

/**
* The Shark Controller Class is the control center
* of the Shark object. It makes a LinkedList of Sharks,
* and uses methods to place Sharks on the game board and
* maintain them
*
* @author    Tommy (Seahoun) Kim
* @version   1.0
* @since     2022-Oct
*/

public class SharkController {
    static LinkedList<Shark> e = new LinkedList<Shark>();

    Shark TempShark;
    
    //constructor for SharkController Class
    public SharkController(){
        addShark(new Shark(40,40));
        addShark(new Shark(220, 560));
    }

    //method to draw all shark objects
    public void draw(Graphics2D g){
        for(int i = 0; i< e.size(); i++){
            TempShark = e.get(i);

            TempShark.draw(g);
        }
    }

    //method to update all shark movement 
    public void update(){
        for (int i = 0; i < e.size(); i++){
            TempShark = e.get(i);

            TempShark.update();
        }
    }

    //method to add shark to the array for maintaining number of sharks
    public void addShark(Shark shark){
        e.add(shark);
    }

    //method to return list that holds all shark objects
    public static LinkedList<Shark> getSharkBounds() {
        return e;
    }
}
