package com.kwiat.kwiaciarnia.Interfaces;

import com.kwiat.kwiaciarnia.Models.Colour;

import java.util.List;

public interface ColourInterface {
    int CreateColour(String colourName);
    int UpdateColour(Colour colour);
    List<Colour> GetAllColours();
    Colour GetColourByID(int id);
    int DeleteColour(int id);
}
