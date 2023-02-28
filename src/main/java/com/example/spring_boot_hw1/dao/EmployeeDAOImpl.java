package com.example.spring_boot_hw1.dao;

import com.example.spring_boot_hw1.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Employee getEmployeeById(int id) {
        return entityManager.find(Employee.class, id);
    }

    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee").getResultList();
    }

    public void addEmployee(Employee employee) {
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    public void deleteEmployeeById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
