package com.Entity;
import java.util.*;
import java.awt.Graphics2D;


public class SquidController extends Entity {
    ArrayList<Squid> squidList = new ArrayList <Squid>();

    Squid tempSquid;

    public SquidController(){
        addSquid(new Squid(880,480));

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
    
    public void squidTouched(boolean touch, int x){
        for(int i=0; i < squidList.size();i++){
            if (x == squidList.get(i).getxPosition()){
                tempSquid =  squidList.get(i);
            }
        }
        tempSquid.setTouched(touch);
    }

}
