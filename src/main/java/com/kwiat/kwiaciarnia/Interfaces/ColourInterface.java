package com.kwiat.kwiaciarnia.Interfaces;

import com.kwiat.kwiaciarnia.Models.Colour;


import java.util.List;

public interface ColourInterface {
    int createColour(String colourName);
    int updateColour(Colour colour);
    List<Colour> getAllColours();
    Colour getColourByID(int id);
    int deleteColour(int id);
}
