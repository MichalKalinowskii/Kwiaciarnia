package com.kwiat.kwiaciarnia.Controllers;

import com.kwiat.kwiaciarnia.Models.Colour;
import com.kwiat.kwiaciarnia.Repository.ColourRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colour")
@Tag(name = "Colour API")
public class ColourController {

    @Autowired
    ColourRepository colourRepository;

    @PostMapping("/create")
    public Mono<ResponseEntity<Colour>> createColour(@RequestBody Colour colour) {
        return colourRepository
                .save(colour)
                .map(col -> new ResponseEntity<>(col, HttpStatus.CREATED));
    }

    @GetMapping("")
    public Flux<Colour> getAllColours() {
        return colourRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Colour>> getColourById(@PathVariable int id) {
        return colourRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> deleteColour(@PathVariable int id) {
        return colourRepository
                .deleteById(id)
                .then(Mono.just(new ResponseEntity<>(HttpStatus.NO_CONTENT)));
    }
}