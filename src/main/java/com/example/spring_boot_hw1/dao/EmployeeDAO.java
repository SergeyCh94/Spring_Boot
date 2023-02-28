package com.example.spring_boot_hw1.dao;

import com.example.spring_boot_hw1.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
