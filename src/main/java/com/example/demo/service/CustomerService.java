package com.example.demo.service;


import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
}
