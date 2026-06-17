package com.boxcarz.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.boxcarz.game.Game;

public class SaveLoad {

    public static void saveGame(Game game) {
        try {
            FileOutputStream fileOut = new FileOutputStream("gameSave.sav");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(game);
            objectOut.flush();
            objectOut.close();
            System.out.println("Game saved!");
        } catch (Exception e) {
            System.out.println("Serialization Error! Can't save game data.\n"
                + e.getClass() + ": " + e.getMessage());
        }
    }

    public static Game loadGame(String gameSave) {
        try {
            FileInputStream fileIn = new FileInputStream(gameSave);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Game game = (Game) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("\n--- Game Loaded ---\n");
            return game;
            
        } catch (Exception e) {
            System.out.println("Serialization Error! Can't load game data.");
            System.out.println(e.getClass() + ": " + e.getMessage());
            return null;
        }
    }
} // END OF CLASS
