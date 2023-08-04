package com.jainbhavuk.EmployeeCRUDApp.repositories;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for accessing the Employee table using JPA.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Find all employees with a specific city.
     *
     * @param city the city to search for
     * @return a list of employees with the specified city
     */
    public List<Employee> findByEmpCity(String city);

    /**
     * Find all employees with a specific age.
     *
     * @param age the age to search for
     * @return a list of employees with the specified age
     */
    public List<Employee> findByEmpAge(Integer age);
}
