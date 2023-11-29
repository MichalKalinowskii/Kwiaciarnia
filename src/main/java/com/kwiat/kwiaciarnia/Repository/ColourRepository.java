package com.kwiat.kwiaciarnia.Repository;

import com.kwiat.kwiaciarnia.Models.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColourRepository extends JpaRepository<Colour, Integer> {
}
