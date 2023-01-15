package com.authentication.domain;

import lombok.EqualsAndHashCode;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * Аналог Аутентификации, роли доступа предоставленной сотруднику
 */

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != 0 && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
