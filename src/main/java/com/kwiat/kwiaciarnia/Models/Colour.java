package com.kwiat.kwiaciarnia.Models;

public class Colour
{
    private int ID;

    private String colourName;

    public Colour(){

    }

    public Colour(int id){
        this.ID = id;
    }

    public Colour(String colourName){
        this.colourName = colourName;
    }

    public Colour(int id,String colourName)
    {
        ID = id;
        this.colourName = colourName;
    }

    public int getID()
    {
        return this.ID;
    }

    public String getColourName()
    {
        return this.colourName;
    }

    public void setID(int id){
        this.ID = id;
    }

    public void setColourName(String colourName)
    {
        this.colourName = colourName;
    }
}