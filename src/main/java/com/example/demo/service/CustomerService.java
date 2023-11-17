package com.example.demo.service;


import com.example.demo.controller.CustomerController;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Food;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(Integer id);
    Customer save(Customer customer);
    Customer update(Customer customer);
    void delete(Integer id);
}
