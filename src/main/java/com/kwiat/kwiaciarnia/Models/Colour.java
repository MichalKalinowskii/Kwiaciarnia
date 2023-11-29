package com.kwiat.kwiaciarnia.Models;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Colour")
public class Colour
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "colourname")
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