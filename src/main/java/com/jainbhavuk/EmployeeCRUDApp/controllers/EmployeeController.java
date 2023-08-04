package com.jainbhavuk.EmployeeCRUDApp.controllers;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import com.jainbhavuk.EmployeeCRUDApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class represents the RESTful API endpoints for managing employees.
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Create a new employee.
     *
     * @param employee The employee object to be created.
     * @return The created employee object.
     */
    @PostMapping("/employee")
    public Employee createNewEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    /**
     * Get all employees.
     *
     * @return A ResponseEntity containing a list of all employees in the system.
     *  If no employees are found, return HttpStatus.NOT_FOUND.
     */
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        if (!employees.isEmpty()) {
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get an employee by their ID.
     *
     * @param empId The ID of the employee to retrieve.
     * @return A ResponseEntity containing the employee object if found, or HttpStatus.NOT_FOUND if not found.
     */
    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer empId) {
        Optional<Employee> emp = employeeService.getEmployeeById(empId);

        if (emp.isPresent()) {
            return new ResponseEntity<>(emp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Update an existing employee by their ID.
     *
     * @param empId    The ID of the employee to be updated.
     * @param employee The updated employee object.
     * @return A message indicating the success of the update operation.
     */
    @PutMapping("/employee/{empId}")
    public String modifyEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
        return employeeService.modifyEmployee(empId, employee);
    }

    /**
     * Delete an employee by their ID.
     *
     * @param empId The ID of the employee to be deleted.
     * @return A message indicating the success of the delete operation.
     */
    @DeleteMapping("/employee/{empId}")
    public String deleteEmployeeById(@PathVariable Integer empId) {
        return employeeService.deleteEmployeeById(empId);
    }

    /**
     * Delete all employees from the system.
     *
     * @return A message indicating the success of the delete operation.
     */
    @DeleteMapping("/employee")
    public String deleteAllEmployees() {
        return employeeService.deleteAllEmployees();
    }

    /**
     * Get a list of employees by the specified city name.
     *
     * @param cityName The name of the city to search for employees.
     * @return A list of employees from the specified city.
     */
    @GetMapping("/employee/city/{cityName}")
    public List<Employee> getEmployeesByCityName(@PathVariable String cityName) {
        return employeeService.getEmployeesByCity(cityName);
    }

    /**
     * Get a list of employees with the specified age.
     *
     * @param age The age to filter employees.
     * @return A list of employees with the specified age.
     */
    @GetMapping("/employee/age/{age}")
    public List<Employee> getEmployeesByAge(@PathVariable Integer age) {
        return employeeService.getEmployeesByAge(age);
    }
}
