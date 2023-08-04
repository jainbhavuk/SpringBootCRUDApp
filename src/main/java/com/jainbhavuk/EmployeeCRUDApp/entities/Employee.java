package com.jainbhavuk.EmployeeCRUDApp.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "empid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_salary")
    private BigDecimal empSalary;

    @Column(name = "emp_age")
    private Integer empAge;

    @Column(name = "emp_city")
    private String empCity;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public BigDecimal getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(BigDecimal empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public Employee(int empId, String empName, BigDecimal empSalary, Integer empAge, String empCity) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.empCity = empCity;
    }

    public Employee() {
    }

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
