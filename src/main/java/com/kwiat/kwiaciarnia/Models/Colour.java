package com.kwiat.kwiaciarnia.Models;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Colour")
public class Colour
{
    @Id
    private int ID;

    @Column("colourname")
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
        this.ID = id;
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