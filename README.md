#Реализация REST API на Spring Boot.

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

![Image of Arch]()
  
Вы можете создать нового работника с сохренение всей информации в БД
-  curl -H 'Content-Type: application/json' -X POST -d '{"name":"Petr","surname":"Shirokov","inn":"0258741"}' http://localhost:8080/employeereport/

![Image of Arch]()
   
Вы можете произвести обновлние записи о работнике в БД, 
либо если такого работника на данный момент не существует он будет добавлен по результату дакого запроса
- curl -i -H 'Content-Type: application/json' -X PUT -d '{"id":"4","name":"John","surname":"Conor","inn":"0000001"}' http://localhost:8080/employeereport/

![Image of Arch]()
  
Вы можете удалить существующего работника из БД
curl -i -X DELETE http://localhost:8080/employeereport/4

![Image of Arch]()

