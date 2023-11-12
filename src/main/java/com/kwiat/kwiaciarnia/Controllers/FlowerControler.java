package com.kwiat.kwiaciarnia.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kwiat.kwiaciarnia.Interfaces.FlowerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.kwiat.kwiaciarnia.Models.Flower;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/flower")
public class FlowerControler {

    @Autowired
    FlowerInterface flowerinterface;

    @PostMapping("/create")
    public int CreateFlower(@RequestBody Flower flower){
        return flowerinterface.CreateFlower(flower);
    }

    @PutMapping("/update/{id}")
    public int UpdateFlower(@PathVariable("id") int id,@RequestBody Flower flower){
        return flowerinterface.UpdateFlower(id, flower);
    }

    @GetMapping("")
    public List<Flower> GetAllFlowers()
    {
        return flowerinterface.GetAllFlowers();
    }

    @GetMapping("/{name}")
    public List<Flower> GetFlowersByName(@PathVariable("name") String name){
        return flowerinterface.GetFlowersByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public int DeleteFlower(@PathVariable("id") int id){
        return flowerinterface.DeleteFlower(id);
    }
     
}