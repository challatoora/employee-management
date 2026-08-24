package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class EmployeeApplication {

    private final List<String> employees = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @GetMapping("/employees")
    public List<String> getEmployees() {
        return employees;
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestParam String name) {
        employees.add(name);
        return "Employee added: " + name;
    }

    @DeleteMapping("/employees/{name}")
    public String deleteEmployee(@PathVariable String name) {
        employees.remove(name);
        return "Employee deleted: " + name;
    }
}