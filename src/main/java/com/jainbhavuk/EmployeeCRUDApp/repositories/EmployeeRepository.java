package com.jainbhavuk.EmployeeCRUDApp.repositories;

import com.jainbhavuk.EmployeeCRUDApp.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
