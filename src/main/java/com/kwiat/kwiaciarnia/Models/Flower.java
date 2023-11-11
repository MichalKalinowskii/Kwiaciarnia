package com.kwiat.kwiaciarnia.Models;

import java.util.concurrent.Flow;

public class Flower {

    private int ID;

    private Colour colour;

    private String name;

    public Flower(){

    }

    public Flower(int id, Colour colour, String name)
    {
        this.ID = id;
        this.colour = colour;
        this.name = name;
    }

    public int getID() { return ID; }

    public Colour getColour()
    {
        return colour;
    }

    public String getName()
    {
        return name;
    }

    public void setID(int id){
        ID = id;
    }

    public void setColour(Colour colour){
        this.colour = colour;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}