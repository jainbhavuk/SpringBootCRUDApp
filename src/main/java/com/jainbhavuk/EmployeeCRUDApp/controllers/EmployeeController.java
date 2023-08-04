package com.jainbhavuk.EmployeeCRUDApp.controllers;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import com.jainbhavuk.EmployeeCRUDApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @GetMapping("/employee/{empId}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empId){
        Optional<Employee> emp = employeeRepository.findById(empId);

        if(emp.isPresent()){
            return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/employee/{empId}")
    private String modifyEmployee(@PathVariable Integer empId, @RequestBody  Employee employee){
      Optional< Employee> existingEmp = employeeRepository.findById(empId);

        if(existingEmp.isPresent()){
            Employee employeeToOverride = existingEmp.get();

            employeeToOverride.setEmpCity(Objects.nonNull(employee.getEmpCity()) ? employee.getEmpCity() : employeeToOverride.getEmpCity());
            employeeToOverride.setEmpName(Objects.nonNull(employee.getEmpName()) ? employee.getEmpName() : employeeToOverride.getEmpName());
            employeeToOverride.setEmpSalary(Objects.nonNull(employee.getEmpSalary()) ? employee.getEmpSalary() : employeeToOverride.getEmpSalary());
            employeeToOverride.setEmpAge(Objects.nonNull(employee.getEmpAge()) ? employee.getEmpAge() : employeeToOverride.getEmpAge());

            employeeRepository.save(employeeToOverride);
            return "Successfully modified the records of employee with id " + empId;
        }
        else {
            return "No record found!";
        }
    }
}
