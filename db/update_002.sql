/*Second schema DB update 28.01.22*/
create table employee
(
    id       serial primary key not null,
    name    varchar(2000),
    surname varchar(2000),
    inn int not null,
    hire_date timestamp without time zone not null default now()
);

INSERT INTO employee (name, surname, inn)
VALUES ('Petr', 'Parsentev', '123456'),
       ('Ivan', 'Sobolev', '234567'),
       ('Fedor', 'Ivanov', '345678');

CREATE TABLE person
(
    id       serial primary key not null,
    login    varchar(2000),
    password varchar(2000),
    employee_id int references employee(id)
);

INSERT INTO person (login, password, employee_id)
VALUES ('Parsentev', '123', 1),
       ('Ivanov', '123', 2),
       ('Blinov', '123', 3);