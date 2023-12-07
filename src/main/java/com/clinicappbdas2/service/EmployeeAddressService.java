package com.clinicappbdas2.service;

import com.clinicappbdas2.model.views.Employee;
import com.clinicappbdas2.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeAddressService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeAddressService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    public void save(Employee employeeAddress) {
        employeeRepository.createEmployee(employeeAddress);
    }
}

