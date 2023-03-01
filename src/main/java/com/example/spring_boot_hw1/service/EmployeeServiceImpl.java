package com.example.spring_boot_hw1.service;

import com.example.spring_boot_hw1.dao.EmployeeRepo;
import com.example.spring_boot_hw1.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeDAO) {
        this.employeeRepo = employeeDAO;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepo.findById(id).get();

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> getAllByName(String name) {
        return employeeRepo.findAllByName(name);
    }
}
