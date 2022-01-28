package ru.job4j.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;

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

    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Person person = (Person) o;
//        return id == person.id && Objects.equals(login, person.login) && Objects.equals(password, person.password);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
