package com.boxcarz.world;

import com.boxcarz.actor.Actor;
import com.boxcarz.game.Game;
import com.boxcarz.commands.Commands;


// MAP CLASS FOR PLAYER/ACTOR MOVEMENT 
public class Map {


    static void moveActorTo(Actor actor, Room room) {
        actor.setRoom(room);
    }
     

    static int moveTo(Actor actor, Direction direction) {
        Room r = actor.getRoom();
        int exit;

        switch (direction) {
            case NORTH:
                exit = r.getNorth();
                break;
            case EAST:
                exit = r.getEast();
                break;
            case SOUTH:
                exit = r.getSouth();
                break;
            case WEST:
                exit = r.getWest();
                break;
            default:
                exit = Direction.NOEXIT; // STAY IN THE SAME ROOM
                break;
        }

        if (exit != Direction.NOEXIT) {
            moveActorTo(actor, Game.map.get(exit));
        }
        return exit;
    }


    static void updateOutput(int roomNumber) {
        if (roomNumber == Direction.NOEXIT) {
            System.out.println("No Exit!");
        } else {
            Commands.look();
        }
    }


    public static void goNorth() {
        updateOutput(moveTo(Game.player, Direction.NORTH));
    }

    public static void goEast() {
        updateOutput(moveTo(Game.player, Direction.EAST));
    }

    public static void goSouth() {
        updateOutput(moveTo(Game.player, Direction.SOUTH));
    }

    public static void goWest() {
        updateOutput(moveTo(Game.player, Direction.WEST));
    }


}

