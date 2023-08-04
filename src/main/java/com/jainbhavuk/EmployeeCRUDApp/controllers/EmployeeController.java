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

/**
 * REST controller for managing employee records.
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Create a new employee record.
     *
     * @param employee the employee object to be created
     * @return the created employee object
     */
    @PostMapping("/employee")
    private Employee createNewEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    /**
     * Get all employee records.
     *
     * @return a response entity containing a list of all employees
     */
    @GetMapping("/employee")
    private ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Get an employee record by ID.
     *
     * @param empId the ID of the employee to retrieve
     * @return a response entity containing the employee object if found, or a NOT_FOUND status if not found
     */
    @GetMapping("/employee/{empId}")
    private ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empId){
        Optional<Employee> emp = employeeRepository.findById(empId);

        if(emp.isPresent()){
            return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);
        }

        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }

    /**
     * Modify an employee record.
     *
     * @param empId the ID of the employee to modify
     * @param employee the modified employee object
     * @return a success message if the employee is modified, or a message if no record is found
     */
    @PutMapping("/employee/{empId}")
    private String modifyEmployee(@PathVariable Integer empId, @RequestBody Employee employee){
        Optional<Employee> existingEmp = employeeRepository.findById(empId);

        if(existingEmp.isPresent()){
            Employee employeeToOverride = existingEmp.get();

            /**
             * Check for null values before saving the new object in order to prevent overriding of already existing values.
             */
            employeeToOverride.setEmpCity(Objects.nonNull(employee.getEmpCity()) ? employee.getEmpCity() : employeeToOverride.getEmpCity());
            employeeToOverride.setEmpName(Objects.nonNull(employee.getEmpName()) ? employee.getEmpName() : employeeToOverride.getEmpName());
            employeeToOverride.setEmpSalary(Objects.nonNull(employee.getEmpSalary()) ? employee.getEmpSalary() : employeeToOverride.getEmpSalary());
            employeeToOverride.setEmpAge(Objects.nonNull(employee.getEmpAge()) ? employee.getEmpAge() : employeeToOverride.getEmpAge());

            employeeRepository.save(employeeToOverride);

            return "Successfully modified the records of employee with id " + empId;
        }

        return "No record found!";
    }

    /**
     * Delete an employee record by ID.
     *
     * @param empId the ID of the employee to delete
     * @return a success message if the employee is deleted, or a message if no record is found
     */
    @DeleteMapping("/employee/{empId}")
    private String deleteEmployeeById(@PathVariable Integer empId){
        Optional<Employee> existingEmp = employeeRepository.findById(empId);

        if(existingEmp.isPresent()) {
            employeeRepository.deleteById(empId);

            return "Successfully Deleted Employee With Id " + empId;
        }

        return "No Record Found!";
    }

    /**
     * Delete all employee records.
     *
     * @return a success message if all records are deleted, or a message if no records are found
     */
    @DeleteMapping("/employee")
    private String deleteAllEmployees(){
        if(!employeeRepository.findAll().isEmpty()) {
            employeeRepository.deleteAll();

            return "All records deleted!";
        }

        return "No records to delete!";
    }

}
