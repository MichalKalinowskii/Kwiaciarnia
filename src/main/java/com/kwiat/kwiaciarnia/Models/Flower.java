package com.kwiat.kwiaciarnia.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "Flower")
public class Flower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ColourID", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Colour colour;

    @Column(name = "Name")
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