#Реализация REST API на Spring Boot.

![GitHub top language](https://img.shields.io/github/languages/top/SlartiBartFast-art/job4j_auth?logo=java&logoColor=red)
![GitHub last commit](https://img.shields.io/github/last-commit/SlartiBartFast-art/job4j_auth?logo=github)

Это простой проект,
представляющий из себя знакомство с RestFull API архитектурой
- архитектура клиент-серверного приложения базирующаяся на 6 принципах.

Used stack technologies:

- Java (Back-end)
- Libraries (java):
- Spring Boot
- Rest API
- Hibernate HQL/ JPA (data-base)
- PostgreSQL PSQL (data-base)
- Gson (parse JSON)
- Maven

Вы можете получить отчет содержащий всех текущих работников и их текущие роли авторизации
- curl -i -X DELETE http://localhost:8080/employeereport/4

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_auth/blob/master/image/Screenshot_1.jpg)
  
Вы можете создать нового работника с сохренение всей информации в БД
-  curl -H 'Content-Type: application/json' -X POST -d '{"name":"Petr","surname":"Shirokov","inn":"0258741"}' http://localhost:8080/employeereport/

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_auth/blob/master/image/Screenshot_2.jpg)
   
Вы можете произвести обновление записи о работнике в БД, 
либо если такого работника на данный момент не существует он будет добавлен по результату дакого запроса,
где "id":"4" текущий id в БД работника
- curl -i -H 'Content-Type: application/json' -X PUT -d '{"id":"4","name":"John","surname":"Conor","inn":"0000001"}' http://localhost:8080/employeereport/

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_auth/blob/master/image/Screenshot_5.jpg)
  
Вы можете удалить существующего работника из БД
- curl -i -X DELETE http://localhost:8080/employeereport/10

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_auth/blob/master/image/Screenshot_4.jpg)
![Image of Arch](https://github.com/SlartiBartFast-art/job4j_auth/blob/master/image/Screenshot_3.jpg)

В свою очередь в браузере при желании вы можете тоже получить отчет от текущих сотрудниках и их ролях авторизации,
который будет след вида:
![Image of Arch](https://github.com/SlartiBartFast-art/job4j_auth/blob/master/image/Screenshot_6.jpg)
