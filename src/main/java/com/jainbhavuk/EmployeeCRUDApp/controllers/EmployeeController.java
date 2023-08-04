package com.jainbhavuk.EmployeeCRUDApp.controllers;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import com.jainbhavuk.EmployeeCRUDApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    private Employee createNewEmployee(@RequestBody  Employee employee){
       return employeeRepository.save(employee);
    }

    @GetMapping("/employee")
    private ResponseEntity<List<Employee>>  getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }
}
