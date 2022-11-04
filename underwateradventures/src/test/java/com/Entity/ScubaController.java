package com.Entity;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class ScubaController {
    static LinkedList<Scubadiver> a = new LinkedList<Scubadiver>();

    Scubadiver TempScuba;
    
    public ScubaController(){
        addScuba(new Scubadiver(680,80));
    }

    public void draw(Graphics2D g){
        for(int i = 0; i< a.size(); i++){
            TempScuba = a.get(i);

            TempScuba.draw(g);
        }
    }

    public void update(Turtle t, Maze m){
        for (int i = 0; i < a.size(); i++){
            TempScuba = a.get(i);

            TempScuba.update(t,m);
        }
    }

    public void addScuba(Scubadiver scubadiver){
        a.add(scubadiver);
    }

    public static LinkedList<Scubadiver> getScubaBounds() {
        return a;
    }
}
