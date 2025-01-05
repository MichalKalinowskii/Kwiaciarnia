package com.kwiat.kwiaciarnia.Repository;

import com.kwiat.kwiaciarnia.Models.Colour;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ColourRepository extends ReactiveCrudRepository<Colour, Integer> {
    //Flux<Colour> findAll();
}
