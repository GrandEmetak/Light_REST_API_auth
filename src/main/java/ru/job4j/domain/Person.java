package ru.job4j.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Аналог Аутентификации, роли доступа предоставленной сотруднику
 * ! использована библиотека Lombok
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Person() {
    }

  public static Person of(int id, String login, String password) {
        Person person = new Person();
        person.id = id;
        person.login = login;
        person.password = password;
        return person;
    }
}
