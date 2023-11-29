package com.kwiat.kwiaciarnia.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kwiat.kwiaciarnia.Models.Flower;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {
}