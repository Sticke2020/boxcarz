package com.boxcarz.commands;

import com.boxcarz.game.Game;
import com.boxcarz.thing.Thing;
import com.boxcarz.thing.ThingList;
import com.boxcarz.world.Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Commands {
   

    private static List<String> commands = new ArrayList<>(
        Arrays.asList(
            "n",
            "e",
            "s",
            "w",
            "i",
            "inventory",
            "take",
            "drop",
            "look",
            "help",
            "save",
            "load"
        )
    );

    public static List<String> getCommands() {
        return commands;
    }

    public static void look(Game game) {
        Room room = game.getPlayer().getRoom();
        System.out.println("You are in the " + room.describe());
    }

    public static void showInventory(Game game) {
        String inventory = game.getPlayer().getThings().describeThings();
        System.out.println(inventory);
    }

    public static void transferItem(Thing item, ThingList from, ThingList to) {
        from.remove(item);
        to.add(item);
    }

    public static String dropItem(Game game, String itemName) {
        String confirm = "";
        Thing item = game.getPlayer().getThings().thisItem(itemName);

        if (itemName.equals("")) {
            confirm = "You will have to tell me which item to drop!\n" + "\n";
        } else if (item == null) {
            confirm = "You dont have one of those!\n" + "\n";
        } else {
            transferItem(
                item,
                game.getPlayer().getThings(),
                game.getPlayer().getRoom().getThings()
            );
            confirm = itemName + " dropped!\n" + "\n";
        }
        return confirm;
    }

    public static String takeItem(Game game, String itemName) {
        String confirm = "";
        Thing item = game.getPlayer().getRoom().getThings().thisItem(itemName);

        if (itemName.equals("")) {
            itemName = "nameless item\n" + "\n";
        }
        if (item == null) {
            confirm = "There is no " + itemName + " here!\n" + "\n";
        } else {
            transferItem(
                item,
                game.getPlayer().getRoom().getThings(),
                game.getPlayer().getThings()
            );
            confirm = itemName + " taken!\n" + "\n";
        }

        return confirm;
    }

    public static void help() {
        System.out.println("_______________________________________________________________");
        System.out.println("|                                                              |");
        System.out.println("|   [ Enter n, s, e, or w ] -- ( to move )                     |");
        System.out.println("|   [ Enter i or inventory ] - ( to check your inventory )     |");
        System.out.println("|   [ Enter look ] ----------- ( to look around )              |");
        System.out.println("|   [ Enter take ] ----------- ( to take an item )             |");
        System.out.println("|   [ Enter drop ] ----------- ( to drop an item )             |");
        System.out.println("|   [ Enter help ] ----------- ( to see the useable commands ) |");
        System.out.println("|   [ Enter save ] ----------- ( to save the current game)     |");
        System.out.println("|   [ Enter load ] ----------- ( to load the last saved game ) |");
        System.out.println("|   [ Enter q ] -------------- ( to quit )                     |");
        System.out.println("|______________________________________________________________|");
        System.out.println("");
    }

 

    
} // END OF CLASS
