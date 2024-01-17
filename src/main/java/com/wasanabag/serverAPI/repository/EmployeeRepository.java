package com.wasanabag.serverAPI.repository;

import com.wasanabag.serverAPI.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
