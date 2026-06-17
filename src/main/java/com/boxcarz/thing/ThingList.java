package com.boxcarz.thing;

import java.util.ArrayList;
import com.boxcarz.item.Item;


public class ThingList extends ArrayList<Thing> {


    public String describeThings() {
        String items = "";

        if (this.size() == 0) {
            items = "nothing.\n";
        } else {
            for (Thing t : this) {
                items = items + t.getName() + ": " + t.getDescription() + ". " +
                    "Value = " + ((Item) t).getValue() + " Gold\n";
            }
        }
        return items;
    }
    

   public Thing thisItem(String name) {
       Thing item = null;
       String itemName = "";
       String nameLowerCase = name.trim().toLowerCase();
       for (Thing t : this) {
           itemName = t.getName().trim().toLowerCase();
           if (itemName.equals(nameLowerCase)) {
               item = t;
            }
        }
       return item;
    }
}
