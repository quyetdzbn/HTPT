package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Food;
import com.example.demo.service.CustomerService;
import com.example.demo.service.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService service;
    
//  public CustomerController(CustomerService service){
//         this.service = service;
//     }

   @GetMapping("/customer")
    public String customer(Model model, Principal principal){
//        if(principal == null){
//            return "redirect:/login";
//        }
        List<Customer> c = service.getAll();
        model.addAttribute("foodList", c);
        model.addAttribute("size", c.size());
        model.addAttribute("title", "c");
        model.addAttribute("Customernew", new Customer());
        return "customers";
    }

        @PostMapping("/add-customer")
    public String add(@ModelAttribute("Customernew") Customer c, RedirectAttributes attributes){
        try {
            service.save(c);
            attributes.addFlashAttribute("success", "Added successfully!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to add because duplicate name!");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server!");
        }
        return "redirect:/customers";
    }
     @RequestMapping(value = "c/findById", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Customer getById(Integer id){
        return service.getById(id);
    }
    @GetMapping("/update-customer")
    public String update(Customer c, RedirectAttributes attributes){
        try {
            service.save(c);
            attributes.addFlashAttribute("success", "Updated successfully!");
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to update because duplicate name");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Error server");
        }
        return "redirect:/customers";
    }
    
    @RequestMapping(value = "/delete-customer", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Integer id, RedirectAttributes attributes){
        try {
            service.delete(id);
            attributes.addFlashAttribute("success", "Deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to deleted");
        }
        return "redirect:/customers";
    }
}
