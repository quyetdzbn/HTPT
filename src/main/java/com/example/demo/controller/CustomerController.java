package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("/customer")
    public List<Customer> getAll(){
        return service.getAll();
    }
}
