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

    @Override
    public Customer getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Customer save(Customer customer) {
        Customer c = new Customer();
        c.setAddr(customer.getAddr());
        c.setFullname(customer.getFullname());
        c.setId_bra(customer.getId_bra());
        c.setId_cus(customer.getId_cus());
        c.setNum(customer.getNum());
        return repo.save(c);
    }

    @Override
    public Customer update(Customer customer) {
        Customer c = null;
        try{
            c = repo.findById(customer.getId_cus()).get();
            c.setAddr(customer.getAddr());
            c.setFullname(customer.getFullname());
            c.setId_bra(customer.getId_bra());
            c.setNum(customer.getNum());

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return repo.save(c);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
