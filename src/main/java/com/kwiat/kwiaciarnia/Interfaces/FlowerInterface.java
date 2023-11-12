package com.kwiat.kwiaciarnia.Interfaces;

import com.kwiat.kwiaciarnia.Models.Flower;

import java.util.List;

public interface FlowerInterface
{
    List<Flower> GetAllFlowers();
    List<Flower> GetFlowersByName(String name);
    int CreateFlower(Flower flower);
    int UpdateFlower(int id, Flower flower);
    int DeleteFlower(int id);
}