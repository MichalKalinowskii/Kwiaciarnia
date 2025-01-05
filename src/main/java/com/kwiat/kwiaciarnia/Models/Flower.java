package com.kwiat.kwiaciarnia.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(name = "Flower")
public class Flower {

    @Id
    private int ID;

    @Transient
    @JsonIgnore
    private Colour colour;

    @Column("Name")
    private String name;

    public Flower(){

    }

    public Flower(int id){
        this.ID = id;
    }

    public Flower(Colour colour, String name){
        this.colour = colour;
        this.name = name;
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
        this.ID = id;
    }

    public void setColour(Colour colour){
        this.colour = colour;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}