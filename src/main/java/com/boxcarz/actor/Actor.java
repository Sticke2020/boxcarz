package com.boxcarz.actor;

import com.boxcarz.thing.ThingHolder;
import com.boxcarz.thing.ThingList;
import com.boxcarz.world.Room;


// This will be a super class for Player, Monster, NPC, Creature, etc
public class Actor extends ThingHolder{
    private Room room;


    public Actor(String name, String description, ThingList thingList, Room room) {
        super(name, description, thingList);
        this.room = room;
    }


    public Room getRoom() {
        return this.room;
    }


    public void setRoom(Room room) {
        this.room = room;
    }


} // END OF CLASS
