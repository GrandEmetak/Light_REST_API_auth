package com.authentication.controller;

import com.authentication.domain.Employee;
import com.authentication.domain.ReportEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Отчетов по существующим Employee + CRUD
 */
@RestController
@RequestMapping("/employee-report")
public class EmployeeReportController {

    private static final String API = "http://localhost:8080/employee/";

    private static final String API_ID = "http://localhost:8080/employee/{id}";

    @Autowired
    private RestTemplate rest;

    /**
     * GET /employee/ - получить список employees.
     * метод для получения отчета со всем списком Employee
     * curl -i http://localhost:8080/employee-report/
     *
     * @return List ReportEmployee
     */
    @GetMapping("/")
    public List<ReportEmployee> findAll() {
        List<ReportEmployee> rsl = new ArrayList<>();
        List<Employee> employees = rest.exchange(API,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                }
        ).getBody();
        for (Employee employee : employees) {
            ReportEmployee reportEmps = ReportEmployee.of(1, "First", employee);
            rsl.add(reportEmps);
        }
        return rsl;
    }

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee rsl = rest.postForObject(API, employee, Employee.class);
        return new ResponseEntity<>(rsl, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Employee employee) {
        rest.put(API, employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        rest.delete(API_ID, id);
        return ResponseEntity.ok().build();
    }
}
