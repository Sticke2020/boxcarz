package com.boxcarz.thing;


public class ThingHolder extends Thing {
    private ThingList things = new ThingList();


    public ThingHolder(String name, String description, ThingList thingList) {
        super(name, description);
        things = thingList;
    }


    public ThingList getThings() {
        return things;
    }


    public void setThings(ThingList things) {
        this.things = things;
    }


} // END OF CLASS
