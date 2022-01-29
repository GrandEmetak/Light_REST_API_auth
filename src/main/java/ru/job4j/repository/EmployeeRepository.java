package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.domain.Employee;

/**
 * Springboot repository Employee
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
