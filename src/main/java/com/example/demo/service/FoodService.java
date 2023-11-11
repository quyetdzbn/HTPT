package com.example.demo.service;

import com.example.demo.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getAll();
    Food getById(Integer id);
    Food save(Food food);
    Food update(Food food);
    void delete(Integer id);
}
