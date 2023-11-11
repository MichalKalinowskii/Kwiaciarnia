package com.kwiat.kwiaciarnia.Models;

public class Colour
{
    private int ID;

    private String _colourName;

    public Colour(){

    }

    public Colour(int id,String colourName)
    {
        ID = id;
        _colourName = colourName;
    }

    public int getID()
    {
        return ID;
    }

    public String getColourName()
    {
        return _colourName;
    }

    public void setID(int id){
        ID = id;
    }

    public void setColourName(String colourName)
    {
        _colourName = colourName;
    }
}