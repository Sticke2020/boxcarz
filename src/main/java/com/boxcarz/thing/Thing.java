package com.boxcarz.thing;


// BASIC THING TYPE THAT DEFINES ALL OBJECTS IN THE GAME
public class Thing { 
    private String name;
    private String description;


    public Thing(String Name, String Description) {
        this.name = Name;
        this.description = Description;
    }


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


} // END OF CLASS
