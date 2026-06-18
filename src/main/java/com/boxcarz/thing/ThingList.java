package com.boxcarz.thing;

import java.util.ArrayList;
import com.boxcarz.item.Item;


public class ThingList extends ArrayList<Thing> {


    public String describeThings() {
        String items = "";

        if (this.size() == 0) {
            items = "None.\n";
        } else {
            for (Thing t : this) {
                if (t instanceof Item item) {
                    items = items + item.describe() + ". " +
                        "Value -> " + item.getValue() + " Gold\n";
                } else if (t instanceof ContainerThing container) {
                    items = items + container.getName() + ":\n";
                }
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
