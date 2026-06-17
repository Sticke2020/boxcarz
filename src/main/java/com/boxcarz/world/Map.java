package com.boxcarz.world;

import com.boxcarz.actor.Actor;
import com.boxcarz.game.Game;
import com.boxcarz.commands.Commands;


// MAP CLASS FOR PLAYER/ACTOR MOVEMENT 
public class Map {


    static void moveActorTo(Actor actor, Room room) {
        actor.setRoom(room);
    }
     

    static int moveTo(Actor actor, Direction direction, Game game) {
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
            moveActorTo(actor, game.getMap().get(exit));
        }
        return exit;
    }


    static void updateOutput(Game game, int roomNumber) {
        if (roomNumber == Direction.NOEXIT) {
            System.out.println("No Exit!\n");
        } else {
            Commands.look(game);
        }
    }


    public static void goNorth(Game game) {
        updateOutput(game, moveTo(game.getPlayer(), Direction.NORTH, game));
    }

    public static void goEast(Game game) {
        updateOutput(game, moveTo(game.getPlayer(), Direction.EAST, game));
    }

    public static void goSouth(Game game) {
        updateOutput(game, moveTo(game.getPlayer(), Direction.SOUTH, game));
    }

    public static void goWest(Game game) {
        updateOutput(game, moveTo(game.getPlayer(), Direction.WEST, game));
    }


}
