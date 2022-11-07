package com.Entity;
import java.util.*;
import java.awt.Graphics2D;


public class SquidController extends Entity {
    ArrayList<Squid> squidList = new ArrayList <Squid>();

    Squid tempSquid;

    public SquidController(){
        addSquid(new Squid(200,200));
        addSquid(new Squid(800,480));
    }

    void addSquid(Squid squid){
        squidList.add(squid);
    }

    public void draw(Graphics2D g){
        for(int i=0; i < squidList.size();i++){
            tempSquid = squidList.get(i);
            tempSquid.setSquid(g);
        }
 
    }  
    
    public void squidTouched(boolean touch, int y){
        for(int i=0; i < squidList.size();i++){  
                if(squidList.get(i).getyPosition()==y)    {
                    tempSquid = squidList.get(i);
                }          
            }
        
        tempSquid.setTouched(touch);
    }

    public void update(Graphics2D g){
        boolean val = tempSquid.touched;
        if(tempSquid.touched == true){
            tempSquid.drawInk(g);
        }
    }

}
