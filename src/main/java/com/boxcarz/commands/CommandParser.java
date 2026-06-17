package com.boxcarz.commands;

import java.util.ArrayList;
import java.util.List;
import com.boxcarz.item.Item;
import com.boxcarz.world.Map;
import com.boxcarz.game.Game;



public class CommandParser {
    private static List<String> commands = Commands.getCommands();
    private static List<String> items = Item.getItems();
    

    // RUNS USER INPUT COMMANDS 
    public static String runCommand(Game game, String input) {
        List<String> wl;
        String response = "ok";
        String inputLowerCase = input.trim().toLowerCase();

        if (!inputLowerCase.equals("q")) {
            if (inputLowerCase.equals("")) {
                response = "You must enter a command";
            } else {
                wl = wordList(inputLowerCase);
                response = parseCommand(game, wl);
            }
        }
        return response;
    } // END OF RUNCOMMAND() METHOD
    

    // Takes the wordlist from wordlist() and parses the words into individual variables
    public static String parseCommand(Game game, List<String> wordlist) {
        String msg;

        if (wordlist.size() == 1) {
            msg = processVerb(game, wordlist);
        } else if (wordlist.size() == 2) {
            msg = processVerbNoun(game, wordlist);
        } else {
            msg = "Only 1 or 2 word commands allowed!";
        }
        return msg;
    } // END OF PARSECOMMAND() METHOD


    public static String processVerb(Game game, List<String> wordlist) {
        String verb = wordlist.get(0);
        String msg = "";

        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb!";
        } else {
            switch (verb) {
                case "n":
                    Map.goNorth(game);
                    break;
                case "e":
                    Map.goEast(game);
                    break;
                case "s":
                    Map.goSouth(game);
                    break;
                case "w":
                    Map.goWest(game);
                    break;
                case "look":
                    Commands.look(game);
                    break;
                case "i":
                case "inventory":
                    Commands.showInventory(game);
                    break;
                case "talk":
                    Commands.talk(game);
                    break;
                case "help":
                    Commands.help();
                   break; 
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }


    public static String processVerbNoun(Game game, List<String> wordlist) {
        String verb = wordlist.get(0);
        String noun = wordlist.get(1);
        String msg = "";
        boolean error = false;

        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
            error = true;
        }
        if (!items.contains(noun)) {
            msg += (noun + " is not a known noun!");
            error = true;
        }
        
        if (!error) {
            switch (verb) {
                case "take":
                    msg = Commands.takeItem(game, noun);
                    break;
                case "drop":
                    msg = Commands.dropItem(game, noun);
                    break;
                default:
                    msg += " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }


    
    // Takes user input and returns it as a list of words that can get fed into the parseCommand()
    public static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> inputWordList = new ArrayList<>();
        String[] words = input.split(delims);

        for (String word : words) {
            inputWordList.add(word);
        }

        return inputWordList;
    } // END OF WORDLIST() METHOD


} // END OF CLASS
