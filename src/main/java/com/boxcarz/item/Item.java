package com.boxcarz.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.boxcarz.thing.Thing;


public class Item extends Thing {
    private static int value;


    public Item(String name, String description, int value) {
        super(name, description);
        this.value = value;
    }


    public static int getValue() {
        return value;
    }


    private static List<String> items = new ArrayList<>(Arrays.asList(
                "sword",
                "ring",
                "water",
                "knife",
                "sweater",
                "crackers"));


    public static List<String> getItems() {
        return items;
    }



}
