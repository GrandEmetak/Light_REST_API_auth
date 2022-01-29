package ru.job4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.job4j.domain.Person;
import ru.job4j.domain.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring boot имеет удобный механизм интеграции Rest сервисов.
 * RestTemplate - позволяет осуществлять вывозы стороннего REST API.
 * в нем мы объявили поле RestTemplate rest с аннотацией @Autowired,
 * поле будет проинициализировано значением бина,
 * который мы объявили ранее в Main class-Job4jAuthApplication.
 * также мы объявили 2 константы, которые мы будем использовать
 * далее для реализации методов в нашем RestController.
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    private static final String API = "http://localhost:8080/person/";

    private static final String API_ID = "http://localhost:8080/person/{id}";

    @Autowired
    private RestTemplate rest;

    /**
     * GET /person/ - получить список пользователей.
     * метод для получения отчета со всем списком Person
     *
     * @return
     */
    @GetMapping("/")
    public List<Report> findAll() {
        List<Report> rsl = new ArrayList<>();
        List<Person> persons = rest.exchange(
                API,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>() {
                }
        ).getBody();
        for (Person person : persons) {
            Report report = Report.of(1, "First", person);
            rsl.add(report);
        }
        return rsl;
    }

    /**
     * -@PostMapping("/")
     * POST /person/ - создать пользователя.
     * запрос имеет вид одной строкой
     * curl -H 'Content-Type: application/json' -X POST -d
     * '{"login":"job4j@gmail.com","password":"123"}' http://localhost:8080/report/
     * String API -Переменная API_ID - содержит параметре {id}, который проставляется в аргументах метода.
     * Spring запущен и происходит запрос Hibernate
     * Hibernate: insert into person (login, password) values (?, ?)
     * что в консоли GitBush
     * Dload  Upload   Total   Spent    Left  Speed
     * 100    95    0    51  100    44    117    101 --:--:-- --:--:-- --:--:--
     * 219{"id":5,"login":"job4j@gmail.com","password":"123"}
     *
     * @param person
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person rsl = rest.postForObject(API, person, Person.class);
        return new ResponseEntity<>(
                rsl,
                HttpStatus.CREATED
        );
    }

    /**
     * PUT /person/ - обновить пользователя.
     * выполняем следующий запрос: одной строкой
     * curl -i -H 'Content-Type: application/json' -X PUT -d
     * '{"id":"13","login":"support@job4j.com","password":"123"}' http://localhost:8080/report/
     * !!!
     * Важно понимать, что если такой записи, которую мы передаем в запросе не будет в БД,
     * то вместо замены будет выполнена вставка.
     *
     * @param person
     * @return
     */
    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Person person) {
        rest.put(API, person);
        return ResponseEntity.ok().build();
    }

    /**
     * DELETE /person/ - удалить пользователя.
     * Выполним запрос, удаляя запись с id = 5:
     * curl -i -X DELETE http://localhost:8080/report/5
     * private static final String API_ID = "http://localhost:8080/person/{id}";
     * Переменная API_ID - содержит параметре {id}, который проставляется в аргументах метода.
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        rest.delete(API_ID, id);
        return ResponseEntity.ok().build();
    }
}
