package com.Entity;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class SharkController {
    static LinkedList<Shark> e = new LinkedList<Shark>();

    Shark TempShark;
    
    public SharkController(){
        addShark(new Shark(40,40));
        addShark(new Shark(80, 560));
    }

    public void draw(Graphics2D g){
        for(int i = 0; i< e.size(); i++){
            TempShark = e.get(i);

            TempShark.draw(g);
        }
    }

    public void update(){
        for (int i = 0; i < e.size(); i++){
            TempShark = e.get(i);

            TempShark.update();
        }
    }

    public void addShark(Shark shark){
        e.add(shark);
    }

    public static LinkedList<Shark> getSharkBounds() {
        return e;
    }
}
