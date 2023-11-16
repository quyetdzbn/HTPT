package com.example.demo.service.impl;

import com.example.demo.entity.Food;
import com.example.demo.repo.FoodRepo;
import com.example.demo.service.FoodService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService{

    private FoodRepo repo;

    public FoodServiceImpl(FoodRepo repo){
        this.repo = repo;
    }

    @Override
    public List<Food> getAll() {
        return repo.findAll();
    }

    @Override
    public Page<Food> searchFood(int pageNo, String keyword) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        List<Food> foodList = repo.findAll();
        Page<Food> page = toPage(foodList, pageable);
        return page;
    }

    @Override
    public Food getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Food save(Food food) {
        Food food1 = new Food();
        food1.setName_foo(food.getName_foo());
        food1.setPrice(food.getPrice());
        food1.setSupplier(food.getSupplier());
        food1.setInStock(food.getInStock());
        return repo.save(food1);
    }

    @Override
    public Food update(Food food) {
        Food food1 = null;
        try{
            food1 = repo.findById(food.getId_foo()).get();
            food1.setName_foo(food.getName_foo());
            food1.setPrice(food.getPrice());
            food1.setSupplier(food.getSupplier());
            food1.setInStock(food.getInStock());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return repo.save(food1);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    private Page toPage(List<Food> list , Pageable pageable){
        if(pageable.getOffset() >= list.size()){
            return Page.empty();
        }
        int startIndex = (int) pageable.getOffset();
        int endIndex = ((pageable.getOffset() + pageable.getPageSize()) > list.size())
                ? list.size()
                : (int) (pageable.getOffset() + pageable.getPageSize());
        List subList = list.subList(startIndex, endIndex);
        return new PageImpl(subList, pageable, list.size());
    }
}
