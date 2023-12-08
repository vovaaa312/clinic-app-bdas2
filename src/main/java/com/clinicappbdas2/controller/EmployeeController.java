package com.clinicappbdas2.controller;

import com.clinicappbdas2.model.views.Employee;
import com.clinicappbdas2.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/zamestnanci-data")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        employeeRepository.createEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeRepository.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteEmployee(id);
    }
}