package com.example.demo.repo;

import com.example.demo.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends JpaRepository<Food, Integer> {
    @Query("select f from Food f where f.name_foo like %?1% or f.supplier like %?1%")
    List<Food> searchFood(String keyword);
}
