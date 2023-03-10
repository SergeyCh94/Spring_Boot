package com.example.spring_boot_hw1.controller;

import com.example.spring_boot_hw1.entity.Employee;
import com.example.spring_boot_hw1.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skypro")
public class RestControllerNew {

    private EmployeeService employeeService;

    public RestControllerNew(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employeeService.addEmployee(employee);
        return employee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.updateEmployee(employee);
        return employee;

    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeService.deleteEmployeeById(id);
        return "Employee with id = " + id + " was deleted";

    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.getAllByName(name);
    }

}
