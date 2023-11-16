package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/login")
    public String showLogin(Model model) {
        // model.addAttribute("message", "Welcome to the login page!");
        return "login";
    }

    @PostMapping("/do-login")
    public String doLogin(@RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        // Tìm kiếm username pass trong bảng employee
        List<Employee> listE = employeeService.getAllEmployees();

        for (Employee employee : listE) {
            if (employee.getUsername() != null) {
                String usn = employee.getUsername().toString();
                String pas = employee.getPassword().toString();
                // System.out.println(usn);
                if (usn.equals(username) && pas.equals(password)) {
                    return "redirect:/";
                }
            }
        }
        // If no match is found, set the error attribute
        model.addAttribute("error1", true);
        return "login";
    }
}
