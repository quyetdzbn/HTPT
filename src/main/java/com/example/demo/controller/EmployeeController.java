package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Food;
import com.example.demo.service.CustomerService;
import com.example.demo.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    EmployeeService service;
    
//  public CustomerController(CustomerService service){
//         this.service = service;
//     }

   @GetMapping("/employee")
    public String employee(Model model, Principal principal){
//        if(principal == null){
//            return "redirect:/login";
//        }
        List<Employee> c = service.getAllEmployees();
        model.addAttribute("foodList", c);
        model.addAttribute("size", c.size());
        model.addAttribute("title", "c");
        model.addAttribute("Employeenew", new Customer());
        return "employee";
    }

        @PostMapping("/add-employee")
    public String add(@ModelAttribute("Employeenew") Employee c, RedirectAttributes attributes){
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
        return "redirect:/employee";
    }
    @RequestMapping(value = "/e/findById", method = {RequestMethod.PUT, RequestMethod.GET})
    @ResponseBody
    public Employee getById(Integer id){
        return service.getById(id);
    }
    @GetMapping("/update-employee")
    public String update(Employee c, RedirectAttributes attributes){
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
        return "redirect:/employee";
    }
    
    @RequestMapping(value = "/delete-employee", method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Integer id, RedirectAttributes attributes){
        try {
            service.delete(id);
            attributes.addFlashAttribute("success", "Deleted successfully");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("failed", "Failed to deleted");
        }
        return "redirect:/employee";
    }
}
