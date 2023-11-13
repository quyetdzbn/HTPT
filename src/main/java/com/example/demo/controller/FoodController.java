package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    private FoodService service;

    public FoodController(FoodService service){
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model){
        List<Food> foodList = service.getAll();
        model.addAttribute("foodList", foodList);
        return "food";
    }
}
