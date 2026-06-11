package com.boxcarz.world;

import com.boxcarz.thing.ThingHolder;
import com.boxcarz.thing.ThingList;


public class Room extends ThingHolder {
    private int north, east, south, west;

    
    public Room(String name, String description, int north, int east, int south, int west, ThingList thingList) {
        super(name, description, thingList);
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
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


    // DESCRIBES THE ITEMS IN THE ROOM
    public String describe() {
        return String.format("%s. %s.",
               getName(), getDescription())
                + "\nItems here:\n" + getThings().describeThings();
    }


} // END OF CLASS
