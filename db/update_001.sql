/*First schema DB create 27.01.22*/
CREATE TABLE person
(
    id       serial primary key not null,
    login    varchar(2000),
    password varchar(2000)
);

INSERT INTO person (login, password)
VALUES ('parsentev', '123'),
       ('blinov', '123'),
       ('ivanov', '123');