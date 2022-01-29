package ru.job4j.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

/**
 * 1. Интеграция Rest сервисов через RestTemplate [#96916]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.8. Rest
 * -. Добавьте модель данных Employee - сотрудник компании. *
 * -. Модель Employee содержит обязательно данные: имя и фамилия,
 * ИНН, дата найма, а также ссылку на список его аккаунтов
 * (в качестве аккаунтов используйте модель Person, в котором используются
 * поля login и пароль), которыми сотрудник пользуется для доступа к ресурсам
 * корпоративной площадки.
 * -. Добавьте контроллер EmployeeController,  в котором добавьте метод получения всех
 * сотрудников со всеми их аккаунтами, добавление нового аккаунта, изменение и удаление
 * существующих аккаунтов.
 * !!! Использована Однонаправленная ассоциация «один ко многим»
 * -@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
 * - @JoinColumn(name = "employee_id") //“fk_employee”)
 * private List<Person> persons = new ArrayList<>();
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
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
}
