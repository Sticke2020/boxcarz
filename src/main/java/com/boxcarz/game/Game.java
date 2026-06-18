package com.boxcarz.game;

import com.boxcarz.actor.*;
import com.boxcarz.item.Item;
import com.boxcarz.thing.ContainerThing;
import com.boxcarz.thing.ThingList;
import com.boxcarz.world.Direction;
import com.boxcarz.world.Room;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable{

    private ArrayList<Room> map;
    private Actor player;

    // The method that runs in the main method to start the game
    public Game() {
        map = new ArrayList<Room>();

        // ADD THINGS TO THE ROOMS
        ThingList cabooseList = new ThingList();
        cabooseList.add(new Item("Bottle", "There is water inside", 5));

        ThingList redBoxCarList = new ThingList();
        redBoxCarList.add(new Item("Knife", "This knife is dull and rusty", 5));
        redBoxCarList.add(
            new Item("Sweater", "The sweater is full of holes", 5)
        );

        ThingList blueBoxCarList = new ThingList();

        ThingList greenBoxCarList = new ThingList();
        greenBoxCarList.add(new Item("Crackers", "Stale crackers", 5));

        ThingList yellowSleeperCarList = new ThingList();

        ThingList playerList = new ThingList();

        ThingList chestList = new ThingList();
        chestList.add(new Item("Marble", "A single glass marble", 3));

        // ADD CONTAINERS / CONTAINERTHINGS
        ContainerThing chest = new ContainerThing(
            "Chest",
            "A small wooden chest, it appears old and worn.",
            false, 
            false,
            true,
            false,
            chestList
        );

        // ADD CONTAINER / CONTAINERTHING TO ROOMLISTS
        cabooseList.add(chest);


        // ADD ROOMS TO THE MAP (N, E, S, W)
        map.add(
            new Room(
                "Caboose",
                "The last car on the train",
                1,
                Direction.NOEXIT,
                Direction.NOEXIT,
                Direction.NOEXIT,
                cabooseList
            )
        );
        map.add(
            new Room(
                "Red BoxCar",
                "A red boxcar",
                2,
                Direction.NOEXIT,
                0,
                Direction.NOEXIT,
                redBoxCarList
            )
        );
        map.add(
            new Room(
                "Blue BoxCar",
                "A blue boxcar",
                3,
                Direction.NOEXIT,
                1,
                Direction.NOEXIT,
                blueBoxCarList
            )
        );
        map.add(
            new Room(
                "Green BoxCar",
                "A green boxcar",
                4,
                Direction.NOEXIT,
                2,
                Direction.NOEXIT,
                greenBoxCarList
            )
        );
        map.add(
            new Room(
                "Yellow SleeperCar",
                "A yellow sleepercar for passengers",
                Direction.NOEXIT,
                Direction.NOEXIT,
                3,
                Direction.NOEXIT,
                yellowSleeperCarList
            )
        );

        // CREATE NPC
        NPC greg = new NPC(
            "Greg",
            "Greg has been living on this train for years.",
            "If you look around you might find some things!"
        );
        NPC allison = new NPC(
            "Allison",
            "Allison was a veterinarian before the apocalypse.",
            "Caring for animals is what I love most!"
        );

        // ADD NPC TO ROOM
        map.get(4).setNPC(greg);
        map.get(2).setNPC(allison);

        // CREATE PLAYER AND PLACE IN ROOM 0
        player = new Actor(
            "Player",
            "A strong apocalypse survivor",
            playerList,
            map.get(0)
        );

        
    } // END OF GAME METHOD

    public ArrayList<Room> getMap() {
        return map;
    }

    public Actor getPlayer() {
        return player;
    }

    // GAME INTRO FOR NEW GAMES
    public static void showIntro() {
        System.out.println("");
        System.out.println("Welcome to boxcarz");
        System.out.println(" ________   ________   ________   ________   ________        ");
        System.out.println("| []  [] | | []  [] | |        | | []  [] | |     [] |__     ");
        System.out.println("|________|-|________|-|________|-|________|-|________|--\\ ");
        System.out.println(" OO    OO   OO    OO   OO    OO   OO    OO   OO    OO \\\\\\\\");
        System.out.println("");
        System.out.println("You are a survivor of the apocalypse.");
        System.out.println("You awake in a train car with no memory of how you got there.");
        System.out.println("It's dim and you are in desperate need of water.");
        System.out.println("Find a way out!"); 
        System.out.println(" ______________________________________________________________");
        System.out.println("|                                                              |");
        System.out.println("|   [ Enter n, s, e, or w ] -- ( to move )                     |");
        System.out.println("|   [ Enter help ] ----------- ( to see the useable commands ) |");
        System.out.println("|   [ Enter save ] ----------- ( to save the current game)     |");
        System.out.println("|   [ Enter load ] ----------- ( to load the last saved game ) |");
        System.out.println("|   [ Enter q ] -------------- ( to quit )                     |");
        System.out.println("|______________________________________________________________|");
        System.out.println("");
    }
} // END OF GAME CLASS
