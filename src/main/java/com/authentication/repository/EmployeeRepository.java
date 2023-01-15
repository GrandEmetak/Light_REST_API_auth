package com.authentication.repository;

import com.authentication.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Springboot repository Employee
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
