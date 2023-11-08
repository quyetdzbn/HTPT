package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Override
    public List<Customer> getAll() {
        return repo.findAll();
    }
}
