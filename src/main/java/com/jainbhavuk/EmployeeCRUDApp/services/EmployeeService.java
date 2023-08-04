package com.jainbhavuk.EmployeeCRUDApp.services;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import com.jainbhavuk.EmployeeCRUDApp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class provides services for managing employees.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Create a new employee.
     *
     * @param employee The employee object to be created.
     * @return The created employee object.
     */
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Get all employees.
     *
     * @return A list of all employees in the system.
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Get an employee by their ID.
     *
     * @param empId The ID of the employee to retrieve.
     * @return An Optional containing the employee object if found, or an empty Optional if not found.
     */
    public Optional<Employee> getEmployeeById(Integer empId) {
        return employeeRepository.findById(empId);
    }

    /**
     * Modify an existing employee by their ID.
     *
     * @param empId    The ID of the employee to be updated.
     * @param employee The updated employee object.
     * @return A message indicating the success of the update operation or if no record was found.
     */
    public String modifyEmployee(Integer empId, Employee employee) {
        Optional<Employee> existingEmp = employeeRepository.findById(empId);

        if (existingEmp.isPresent()) {
            Employee employeeToOverride = existingEmp.get();

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
     * Delete an employee by their ID.
     *
     * @param empId The ID of the employee to be deleted.
     * @return A message indicating the success of the delete operation or if no record was found.
     */
    public String deleteEmployeeById(Integer empId) {
        Optional<Employee> existingEmp = employeeRepository.findById(empId);

        if (existingEmp.isPresent()) {
            employeeRepository.deleteById(empId);

            return "Successfully Deleted Employee With Id " + empId;
        }

        return "No Record Found!";
    }

    /**
     * Delete all employees from the system.
     *
     * @return A message indicating the success of the delete operation or if there are no records to delete.
     */
    public String deleteAllEmployees() {
        if (!employeeRepository.findAll().isEmpty()) {
            employeeRepository.deleteAll();

            return "All records deleted!";
        }

        return "No records to delete!";
    }

    /**
     * Get a list of employees by the specified city name.
     *
     * @param cityName The name of the city to search for employees.
     * @return A list of employees from the specified city.
     */
    public List<Employee> getEmployeesByCity(String cityName) {
        return employeeRepository.findByEmpCity(cityName);
    }

    /**
     * Get a list of employees with the specified age.
     *
     * @param age The age to filter employees.
     * @return A list of employees with the specified age.
     */
    public List<Employee> getEmployeesByAge(Integer age) {
        return employeeRepository.findByEmpAge(age);
    }
}
