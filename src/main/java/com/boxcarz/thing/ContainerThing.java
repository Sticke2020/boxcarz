package com.boxcarz.thing;

public class ContainerThing extends ThingHolder{
    private boolean openable;
    private boolean isOpen;

    public ContainerThing(String name, String description, ThingList thingList) {
        super(name, description, thingList);
        openable = false;
        isOpen = true;
    }

    public ContainerThing(String name, String description, boolean canTake, boolean canMove,
        boolean canOpen, boolean openOrShut, ThingList thingList) {
        super(name, description, canTake, canMove, thingList);
        openable = canOpen;
        isOpen = openOrShut;
    }

    // GETTERS AND SETTERS
    public boolean isOpenable() {
        return openable;
    }

    public void setOpenable(boolean openable) {
        this.openable = openable;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;
    }

    public String describe() {
        String description;
        String thingsDescription;

        description = "This is " + getDescription();
        thingsDescription = getThings().describeThings();

        if (!thingsDescription.isEmpty()) {
            description += "\nIn the " + getName() + " you can see:\n" + thingsDescription;
        }
        return description;
    }
    
    
} // END OF CLASS
