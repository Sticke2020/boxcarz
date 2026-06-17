package com.boxcarz.world;

import java.util.ArrayList;

import com.boxcarz.actor.NPC;
import com.boxcarz.thing.ThingHolder;
import com.boxcarz.thing.ThingList;


public class Room extends ThingHolder {
    private int north, east, south, west;
    private ArrayList<NPC> npcs;

    
    public Room(String name, String description, int north, int east, int south, int west, ThingList thingList) {
        super(name, description, thingList);
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.npcs = new ArrayList<>();
    } 
    
    
    // GETTERS AND SETTERS
    public int getNorth() {
        return north;
    }


    public void setNorth(int n) {
        this.north = n;
    }


    public int getEast() {
        return east;
    }


    public void setEast(int e) {
        this.east = e;
    }


    public int getSouth() {
        return south;
    }


    public void setSouth(int s) {
        this.south = s;
    }


    public int getWest() {
        return west;
    }


    public void setWest(int w) {
        this.west = w;
    }

    public void setNPC(NPC npc) {
        npcs.add(npc);
    }

    public ArrayList<NPC> getNPCs() {
        return npcs;
    }


    // DESCRIBES THE ITEMS IN THE ROOM
    public String describe() {
        String n = "None.";
        for (NPC npc : getNPCs()) {
            n = NPC.describeNPC(npc);
        }
        return String.format("%s. %s.",
               getName(), getDescription()) + "\n"
                + "\nItems here:\n" + getThings().describeThings()
                + "\nLifeforms here:\n" + n + "\n";
    }


} // END OF CLASS
