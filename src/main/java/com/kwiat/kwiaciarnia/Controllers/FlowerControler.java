package com.kwiat.kwiaciarnia.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kwiat.kwiaciarnia.Interfaces.FlowerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.kwiat.kwiaciarnia.Models.Flower;

@CrossOrigin(origins = "https://localhost:8081")
@RestController
@RequestMapping("/flower")
public class FlowerControler {

    @Autowired
    FlowerInterface _flowerInterface;

    @GetMapping("")
    public List<Flower> GetAllFlowers()
    {
        return _flowerInterface.GetAllFlowers();
    }

    @GetMapping("/{name}")
    public List<Flower> GetFlowersByName(@PathVariable("name") String name){
        return _flowerInterface.GetFlowersByName(name);
    }
}