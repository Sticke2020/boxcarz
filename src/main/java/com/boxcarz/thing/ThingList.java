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
                    "Value = " + Item.getValue() + " Gold\n";
            }
        }
        return items;
    }


}
