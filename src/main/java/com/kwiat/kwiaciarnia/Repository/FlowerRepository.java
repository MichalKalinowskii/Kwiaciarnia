package com.kwiat.kwiaciarnia.Repository;

import com.kwiat.kwiaciarnia.Models.Flower;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface FlowerRepository extends ReactiveCrudRepository<Flower, Integer> {
    //Flux<Flower> findAll();                      // Wszystkie kwiaty
    //Mono<Flower> findById(int id);
}