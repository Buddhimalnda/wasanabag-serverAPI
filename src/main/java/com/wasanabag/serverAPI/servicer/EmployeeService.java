package com.wasanabag.serverAPI.servicer;

import com.wasanabag.serverAPI.model.Employee;
import com.wasanabag.serverAPI.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(String id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setPassword(employee.getPassword());
        employee1.setPhone(employee.getPhone());
        employee1.setAddress(employee.getAddress());
        employee1.setRole(employee.getRole());
        employee1.setStatus(employee.getStatus());
        employee1.setCreatedAt(employee.getCreatedAt());
        employee1.setUpdatedAt(employee.getUpdatedAt());
        return employeeRepository.save(employee1);
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
