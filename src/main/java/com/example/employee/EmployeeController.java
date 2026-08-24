package com.example.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/")
    public String home() {
        return "Employee Management Application is running!";
    }

    @GetMapping("/employees")
    public String employees() {
        return "Employee API is working!";
    }
}