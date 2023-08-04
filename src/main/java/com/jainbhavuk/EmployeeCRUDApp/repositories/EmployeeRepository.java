package com.jainbhavuk.EmployeeCRUDApp.repositories;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for accessing the Employee Table using JPA
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
