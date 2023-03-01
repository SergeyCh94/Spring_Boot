package com.example.spring_boot_hw1.dao;

import com.example.spring_boot_hw1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
        List<Employee> findAllByName(String name);
}
