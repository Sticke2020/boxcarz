package com.boxcarz.item;

import com.boxcarz.item.Item;
import com.boxcarz.thing.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item extends Thing {

    private int value;

    public Item(String name, String description, int value) {
        super(name, description);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static List<String> items = new ArrayList<>(
        Arrays.asList(
            "sword",
            "ring",
            "water",
            "knife",
            "sweater",
            "crackers",
            "bottle"
        )
    );

    public static List<String> getItems() {
        return items;
    }
} // END OF CLASS
