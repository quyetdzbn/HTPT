package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.service.FoodService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class FoodController {
    private FoodService service;

    public FoodController(FoodService service){
        this.service = service;
    }

    @GetMapping("/foods")
    public String foods(Model model, Principal principal){
//        if(principal == null){
//            return "redirect:/login";
//        }
        List<Food> foods = service.getAll();
        model.addAttribute("foodList", foods);
        model.addAttribute("size", foods.size());
        model.addAttribute("title", "Food");
        model.addAttribute("foodNew", new Food());
        return "foods";
    }

    @PostMapping("/add-food")
    public String add(@ModelAttribute("foodNew") Food food, RedirectAttributes attributes){
        try {
            service.save(food);
            attributes.addFlashAttribute("success", "Added successfully!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to add because duplicate name!");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server!");
        }
        return "redirect:/foods";
    }

    @RequestMapping(value = "/findById", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Food getById(Integer id){
        return service.getById(id);
    }

    @GetMapping("/update-food")
    public String update(Food food, RedirectAttributes attributes){
        try {
            service.save(food);
            attributes.addFlashAttribute("success", "Updated successfully!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to update because duplicate name");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server");
        }
        return "redirect:/foods";
    }

    @RequestMapping(value = "/delete-food", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Integer id, RedirectAttributes attributes){
        try {
            service.delete(id);
            attributes.addFlashAttribute("success", "Deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to deleted");
        }
        return "redirect:/foods";
    }
}
