package com.jainbhavuk.EmployeeCRUDApp.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Entity class representing the "employee" table in the database.
 */
@Entity
@Table(name = "employee")
public class Employee {

    /**
     * Primary key column for the employee.
     */
    @Id
    @Column(name = "empid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    /**
     * Name of the employee.
     */
    @Column(name = "emp_name")
    private String empName;

    /**
     * Salary of the employee.
     */
    @Column(name = "emp_salary")
    private BigDecimal empSalary;

    /**
     * Age of the employee.
     */
    @Column(name = "emp_age")
    private Integer empAge;

    /**
     * City of the employee.
     */
    @Column(name = "emp_city")
    private String empCity;

    /**
     * Default constructor.
     */
    public Employee() {
    }

    /**
     * Parameterized constructor for employee.
     *
     * @param empId   the employee ID
     * @param empName the employee name
     * @param empSalary the employee salary
     * @param empAge the employee age
     * @param empCity the employee city
     */
    public Employee(int empId, String empName, BigDecimal empSalary, Integer empAge, String empCity) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.empCity = empCity;
    }

    /**
     * Getter for empId.
     *
     * @return the employee ID
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * Setter for empId.
     *
     * @param empId the employee ID to set
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * Getter for empName.
     *
     * @return the employee name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Setter for empName.
     *
     * @param empName the employee name to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * Getter for empSalary.
     *
     * @return the employee salary
     */
    public BigDecimal getEmpSalary() {
        return empSalary;
    }

    /**
     * Setter for empSalary.
     *
     * @param empSalary the employee salary to set
     */
    public void setEmpSalary(BigDecimal empSalary) {
        this.empSalary = empSalary;
    }

    /**
     * Getter for empAge.
     *
     * @return the employee age
     */
    public Integer getEmpAge() {
        return empAge;
    }

    /**
     * Setter for empAge.
     *
     * @param empAge the employee age to set
     */
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    /**
     * Getter for empCity.
     *
     * @return the employee city
     */
    public String getEmpCity() {
        return empCity;
    }

    /**
     * Setter for empCity.
     *
     * @param empCity the employee city to set
     */
    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    /**
     * toString method for Employee class.
     *
     * @return a string representation of the Employee object
     */
    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSalary=" + empSalary +
                ", empAge=" + empAge +
                ", empCity='" + empCity + '\'' +
                '}';
    }
}
