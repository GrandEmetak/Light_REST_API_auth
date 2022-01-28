package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.domain.Person;

import ru.job4j.servise.PersonService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * 0. RESTFull. Описание архитектуры [#6884]
 * Уровень : 3. МидлКатегория : 3.4. SpringТопик : 3.4.8. Rest
 * 1. Создать новый проект job4j_auth.
 * 2. Создать REST service для модели Person
 * 3. Составить полноценные junit тесты.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> findAll() {
        return StreamSupport.stream(
                this.personService.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable int id) {
        var person = this.personService.findById(id);
        return new ResponseEntity<Person>(
                person.orElse(new Person()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<Person>(
                this.personService.save(person),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        this.personService.save(person);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Person person = new Person();
        person.setId(id);
        this.personService.delete(person);
        return ResponseEntity.ok().build();
    }
}