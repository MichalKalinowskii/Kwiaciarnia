package com.kwiat.kwiaciarnia.Controllers;

import com.kwiat.kwiaciarnia.Models.Flower;
import com.kwiat.kwiaciarnia.Repository.FlowerRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/flower")
@Tag(name = "Flower API")
public class FlowerController {

    @Autowired
    FlowerRepository flowerRepository;

    @PostMapping("/create")
    public Mono<ResponseEntity<Flower>> createFlower(@RequestBody Flower flower) {
        return flowerRepository
                .save(flower)
                .map(flw -> new ResponseEntity<>(flw, HttpStatus.CREATED));
    }

    @GetMapping("")
    public Flux<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Flower>> getFlowerById(@PathVariable int id) {
        return flowerRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deleteFlower(@PathVariable int id) {
        return flowerRepository
                .deleteById(id)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }
}