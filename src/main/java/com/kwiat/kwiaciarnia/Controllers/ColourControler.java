package com.kwiat.kwiaciarnia.Controllers;

import com.kwiat.kwiaciarnia.Interfaces.ColourInterface;
import com.kwiat.kwiaciarnia.Models.Colour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colour")
public class ColourControler {

    @Autowired
    ColourInterface colourInterface;

    @PostMapping("/create/{colourName}")
    public int CreateColour(@PathVariable("colourName") String colourName){
        return colourInterface.CreateColour(colourName);
    }

    @PutMapping("/update")
    public int UpdateColour(@RequestBody Colour colour){
        return colourInterface.UpdateColour(colour);
    }

    @GetMapping("")
    public List<Colour> GetAllColours(){
        return colourInterface.GetAllColours();
    }

    @GetMapping("/{id}")
    public Colour GetColourByID(@PathVariable("id") int id){
        return colourInterface.GetColourByID(id);
    }

    @DeleteMapping("delete/{id}")
    public int DeleteColour(@PathVariable("id") int id){
        return colourInterface.DeleteColour(id);
    }
}
