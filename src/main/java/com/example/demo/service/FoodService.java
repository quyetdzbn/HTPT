package com.example.demo.service;

import com.example.demo.entity.Food;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FoodService {
    List<Food> getAll();
    Food getById(String id);
    Food save(Food food);
    Food update(Food food);
    void delete(String id);
}
