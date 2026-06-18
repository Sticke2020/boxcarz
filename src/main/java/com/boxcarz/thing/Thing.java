package com.boxcarz.thing;

import java.io.Serializable;

// BASIC THING TYPE THAT DEFINES ALL OBJECTS IN THE GAME
public class Thing implements Serializable { 
    private String name;
    private String description;
    private boolean takable;
    private boolean movable;


    public Thing(String Name, String Description) {
        this.name = Name;
        this.description = Description;
        this.takable = true;
        this.movable = true;
    }

    public Thing(String Name, String Description, boolean canTake, boolean canMove) {
        this.name = Name;
        this.description = Description;
        this.takable = canTake;
        this.movable = canMove;
    }
   
   public String describe() {
       return name + ": " + description;
   }
    
    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }


    public void setName(String Name) {
        this.name = Name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String Description) {
        this.description = Description;
    }

    public boolean isTakable() {
        return takable;
    }

    public void setTakable(boolean takable) {
        this.takable = takable;
    }

    public boolean isMoveable() {
        return movable;
    }

    public void setMovabel(boolean movable) {
        this.movable = movable;
    }
} // END OF CLASS
