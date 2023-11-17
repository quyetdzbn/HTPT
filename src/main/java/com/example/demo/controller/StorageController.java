package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.entity.Storage;
import com.example.demo.service.FoodService;
import com.example.demo.service.StorageService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;
import java.util.List;

@Controller
public class StorageController {
    private StorageService service;

    public StorageController(StorageService service){
        this.service = service;
    }

    @GetMapping("/storages")
    public String storages(Model model, Principal principal){
//        if(principal == null){
//            return "redirect:/login";
//        }
        List<Storage> storages = service.getAll();
        model.addAttribute("storages", storages);
        model.addAttribute("size", storages.size());
        model.addAttribute("title", "Storage");
        model.addAttribute("storageNew", new Storage());
        return "storages";
    }

    @PostMapping("/add-storage")
    public String add(@ModelAttribute("storageNew") Storage storage, RedirectAttributes attributes){
        try {
            service.save(storage);
            attributes.addFlashAttribute("success", "Added successfully!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to add because duplicate name!");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server!");
        }
        return "redirect:/storages";
    }

    @RequestMapping(value = "/findByIdStorage", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Storage getById(String id){
        return service.getById(id);
    }

    @GetMapping("/update-storage")
    public String update(Storage storage, RedirectAttributes attributes){
        try {
            service.update(storage);
            attributes.addFlashAttribute("success", "Updated successfully!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to update because duplicate name");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server");
        }
        return "redirect:/storages";
    }

    @RequestMapping(value = "/delete-storage", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(String id, RedirectAttributes attributes){
        try {
            service.delete(id);
            attributes.addFlashAttribute("success", "Deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to deleted");
        }
        return "redirect:/storages";
    }
}
