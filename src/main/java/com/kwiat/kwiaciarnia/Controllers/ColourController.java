package com.kwiat.kwiaciarnia.Controllers;

import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Repository.ColourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colour")
public class ColourController {

    @Autowired
    ColourRepository colourRepository;

    @PostMapping("/create/{colourName}")
    public ResponseEntity<Colour> createColour(@PathVariable("colourName") String colourName){
        Colour colour = colourRepository.save(new Colour(colourName));
        return new ResponseEntity<>(colour, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Colour> updateColour(@RequestBody Colour colour){
        Colour _colour = colourRepository.findById(colour.getID()).get();
        _colour.setColourName(colour.getColourName());
        return new ResponseEntity<>(colourRepository.save(_colour), HttpStatus.OK);
    }

    @GetMapping("")
    public List<Colour> getAllColours(){
        List<Colour> colours = new ArrayList<Colour>();
        colourRepository.findAll().forEach(colours::add);
        return colours;
    }

    @GetMapping("/{id}")
    public Colour getColourByID(@PathVariable("id") int id){
        return colourRepository.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteColour(@PathVariable("id") int id){
        colourRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
