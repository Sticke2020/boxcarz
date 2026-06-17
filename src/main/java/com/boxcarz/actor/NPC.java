package com.boxcarz.actor;

import com.boxcarz.thing.Thing;

public class NPC extends Thing {
    private String dialogue;
    
public NPC(String name, String description, String dialogue) {
    super(name, description);
    this.dialogue = dialogue;
}

public String getDialogue() {
    return dialogue;
}

public static String describeNPC(NPC npc) {
    String n = "None.";

    if (!npc.equals(null)) {
        n = npc.getName() + ": " + npc.getDescription();
    }
    
    return n;
}
    
    
} // END OF CLASS
