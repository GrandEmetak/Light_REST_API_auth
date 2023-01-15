package com.authentication.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * модель данных Employee - сотрудник компании.
 * Модель Employee содержит обязательно данные:
 * имя и фамилия,
 * ИНН, дата найма, а также ссылку на список его аккаунтов
 * (в качестве аккаунтов используйте модель Person, в котором используются
 * поля login и пароль), которыми сотрудник пользуется для доступа к ресурсам
 * корпоративной площадки.
 */

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "inn")
    private int inn;

    @Column(name = "hire_date")
    private Timestamp hireDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employee_id")
    private List<Person> persons = new ArrayList<>();

    public Employee() {
    }

    public Employee of(String name, String surname, int inn, Timestamp hireDate, List<Person> persons) {
        Employee employee = new Employee();
        employee.name = name;
        employee.surname = surname;
        employee.inn = inn;
        employee.hireDate = hireDate;
        employee.persons = persons;
        return employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id
                && inn == employee.inn
                && Objects.equals(name, employee.name)
                && Objects.equals(surname, employee.surname)
                && Objects.equals(hireDate, employee.hireDate)
                && Objects.equals(persons, employee.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, inn, hireDate, persons);
    }
}
