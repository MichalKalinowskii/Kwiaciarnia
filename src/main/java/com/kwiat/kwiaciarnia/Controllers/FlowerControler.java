package com.kwiat.kwiaciarnia.Controllers;

import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Repository.ColourRepository;
import com.kwiat.kwiaciarnia.Repository.FlowerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kwiat.kwiaciarnia.Interfaces.FlowerInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import com.kwiat.kwiaciarnia.Models.Flower;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/flower")
public class FlowerControler {

    @Autowired
    FlowerRepository flowerRepository;

    @Autowired
    ColourRepository colourRepository;

    @PostMapping("/create")
    public ResponseEntity<Flower> createFlower(@RequestBody Flower flower){
        Flower _flower = colourRepository.findById(flower.getColour().getID()).map(colour -> {
          flower.setColour(colour);
          return flowerRepository.save(flower);
        }).get();
        return  new ResponseEntity<>(_flower, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Flower> UpdateFlower(@RequestBody Flower flower){
        Flower _flower = colourRepository.findById(flower.getColour().getID()).map(colour -> {
            flower.setColour(colour);
            return flower;
        }).get();
        flowerRepository.save(_flower);
        return new ResponseEntity<>(_flower, HttpStatus.OK);
    }

    @GetMapping("")
    public List<Flower> getAllFlowers()
    {
        List<Flower> flowers = new ArrayList<Flower>();
        flowerRepository.findAll().forEach(flowers::add);
        return flowers;
    }

    @GetMapping("/{id}")
    public Flower getFlowerByID(@PathVariable("id") int id){
        return flowerRepository.findById(id).get();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFlower(@PathVariable("id") int id){
        flowerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}