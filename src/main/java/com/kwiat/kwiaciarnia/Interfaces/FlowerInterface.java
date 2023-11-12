package com.kwiat.kwiaciarnia.Interfaces;

import com.kwiat.kwiaciarnia.Models.Flower;

import java.util.List;

public interface FlowerInterface
{
    List<Flower> GetAllFlowers();
    Flower GetFlowerByID(int id);
    int CreateFlower(Flower flower);
    int UpdateFlower(Flower flower);
    int DeleteFlower(int id);
}