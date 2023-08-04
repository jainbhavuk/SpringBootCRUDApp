package com.jainbhavuk.EmployeeCRUDApp.entities;

import jakarta.persistence.*;

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
    private Float empSalary;

    @Column(name = "emp_age")
    private int empAge;

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

    public Float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Float empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public Employee(int empId, String empName, Float empSalary, int empAge, String empCity) {
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
