package com.example.demo.service.impl;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    
    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public Employee save(Employee employee) {
        Employee e = new Employee();
        e.setAddr(employee.getAddr());
        e.setAge(employee.getAge());
        e.setFullname(employee.getFullname());
        e.setId_bra(employee.getId_bra());
        e.setId_emp(employee.getId_emp());
        e.setSal(employee.getSal());
        return repo.save(e);
    }
    @Override
    public Employee update(Employee employee) {
        Employee e = null;
        try{
            e =  repo.findById(employee.getId_emp()).get();
            e.setAddr(employee.getAddr());
            e.setAge(employee.getAge());
            e.setFullname(employee.getFullname());
            e.setId_bra(employee.getId_bra());
            e.setSal(employee.getSal());
        }

        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return repo.save(e);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
