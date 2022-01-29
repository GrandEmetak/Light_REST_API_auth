/*Second schema DB update 28.01.22*/
create table employee
(
    id       serial primary key not null,
    name    varchar(2000),
    surname varchar(2000),
    inn int not null,
    hire_date timestamp without time zone not null default now()
);

insert into employee (name, surname, inn)
values ('Petr', 'parsentev', '123456');
insert into employee (name, surname, inn)
values ('Ivan', 'Sobolev', '234567');
insert into employee (name, surname, inn)
values ('Fedor', 'Ivanov', '345678');

create table person
(
    id       serial primary key not null,
    login    varchar(2000),
    password varchar(2000),
    employee_id int references employee(id)
);

insert into person (login, password, employee_id)
values ('parsentev', '123', 1);
insert into person (login, password, employee_id)
values ('ivan', '123', 2);
insert into person (login, password, employee_id)
values ('dan', '123', 3);