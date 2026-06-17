package com.boxcarz;

import java.io.IOException;

import com.boxcarz.commands.CommandParser;
import com.boxcarz.game.Game;
import com.boxcarz.util.InputHelper;
import com.boxcarz.util.SaveLoad;



public class Main {


    public static void main(String[] args) throws IOException{
        Game game = new Game();
        String input;
        String output = "";

        Game.showIntro();

        do {
            System.out.print("> ");
            input = InputHelper.readLine();
            
            switch (input) {
                case "save":
                    SaveLoad.saveGame(game);
                    break;
                case "load":
                    game = SaveLoad.loadGame("gameSave.sav");
                    break;
                default:
                    output = CommandParser.runCommand(game, input);
                    break;
            }
            System.out.print(output);
        } while (!"q".equals(input));
        
    } // END OF MAIN METHOD


} // END OF MAIN CLASS
