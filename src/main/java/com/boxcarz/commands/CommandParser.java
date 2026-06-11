package com.boxcarz.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.boxcarz.commands.Commands;
import com.boxcarz.item.Item;
import com.boxcarz.world.Map;



public class CommandParser {
    private static List<String> commands = Commands.getCommands();
    private static List<String> items = Item.getItems();
    

    // RUNS USER INPUT COMMANDS 
    public static String runCommand(String input) {
        List<String> wl;
        String response = "ok";
        String inputLowerCase = input.trim().toLowerCase();

        if (!inputLowerCase.equals("q")) {
            if (inputLowerCase.equals("")) {
                response = "You must enter a command";
            } else {
                wl = wordList(inputLowerCase);
                response = parseCommand(wl);
            }
        }
        return response;
    } // END OF RUNCOMMAND() METHOD
    

    // Takes the wordlist from wordlist() and parses the words into individual variables
    public static String parseCommand(List<String> wordlist) {
        String msg;

        if (wordlist.size() == 1) {
            msg = processVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = processVerbNoun(wordlist);
        } else {
            msg = "Only 1 or 2 word commands allowed!";
        }
        return msg;
    } // END OF PARSECOMMAND() METHOD


    public static String processVerb(List<String> wordlist) {
        String verb = wordlist.get(0);
        String msg = "";

        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb!";
        } else {
            switch (verb) {
                case "n":
                    Map.goNorth();
                    break;
                case "e":
                    Map.goEast();
                    break;
                case "s":
                    Map.goSouth();
                    break;
                case "w":
                    Map.goWest();
                    break;
                case "look":
                    Commands.look();
                    break;
                default:
                    msg = verb + " (not yet implemented)";
                    break;
            }
        }
        return msg;
    }


    public static String processVerbNoun(List<String> wordlist) {
        String verb = wordlist.get(0);
        String noun = wordlist.get(1);
        String msg = "";

        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        }
        if (!items.contains(noun)) {
            msg += (noun + " is not a known noun!");
        }
        msg += " (not yet implemented)";
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
