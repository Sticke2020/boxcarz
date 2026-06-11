package com.boxcarz.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.boxcarz.game.Game;
import com.boxcarz.world.Room;


public class Commands {
    private static List<String> commands = new ArrayList<>(Arrays.asList(
        "n",
        "e",
        "s",
        "w",
        "take",
        "drop",
        "look"));

    public static List<String> getCommands() {
        return commands;
    }


    public static void look() {
        Room room = Game.getPlayer().getRoom();
        System.out.println("You are in the " + room.describe());
    }


} // END OF CLASS

