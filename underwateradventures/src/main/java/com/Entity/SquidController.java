package com.Entity;
import java.util.*;
import java.awt.Graphics2D;

/**
* The Squid Controller class (extends from Entity)
* Keeps track of the number of squids on the board.
* Uses methods from Squid class to create and maintain 
* squid objects
*
* @author  Hazelle Lebumfacil
* @version 1.0
* @since   2022-Oct 
*/

public class SquidController extends Entity {
    public ArrayList<Squid> squidList = new ArrayList <Squid>();

    Squid tempSquid;
    //constructor for squidController
    public SquidController(){
        addSquid(new Squid(160,200));
        addSquid(new Squid(800,480));
    }
    //method to add squid to list for maintaining number of squid objects 
    
    public void addSquid(Squid squid){
        squidList.add(squid);
    }

    public void squidRestart(){
        Maze.mapGrid[4][5] = 'Q';
        Maze.mapGrid[20][12] = 'Q';
    }

    //method to draw all squid objects
    public void draw(Graphics2D g){
        for(int i=0; i < squidList.size();i++){
            tempSquid = squidList.get(i);
            tempSquid.setSquid(g);
        }
 
    }  
    //method to check which squid from list has been touched
    public void squidTouched(boolean touch, int y){
        for(int i=0; i < squidList.size();i++){  
                if(squidList.get(i).getyPosition()==y)    {
                    tempSquid = squidList.get(i);
                }          
            }
        
        tempSquid.setTouched(touch);
    }
    //method to trigger the punishment if a squid has been touched
    public void update(Graphics2D g){
        boolean val = tempSquid.touched;
        if(tempSquid.touched == true){
            tempSquid.drawInk(g);
        }
    }

}
