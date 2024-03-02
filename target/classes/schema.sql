create schema if not exists netology;
create table if not exists netology.customers
(
    id           serial primary key,
    name         varchar(50) not null,
    surname      varchar(50) not null,
    age          int check ( age > 0 and age < 110 ),
    phone_number varchar(15)
    );

insert into netology.customers(name, surname, age, phone_number)
values ('John','Brown',15,'555768') ,
       ('Alexey','Petrov',20,'9166756437') ,
       ('Mary','Green',99,'7658732') ,
       ('Denis','Golubev',58,'9362637482') ,
       ('Kate','Katina',86,'9187362736') ,
       ('Alexey','Wood',13,'37637473') ;

create table if not exists netology.orders
(
    id           serial primary key,
    date         date,
    customer_id  int,
    product_name varchar(255)            not null,
    amount       int check (amount > 0 ) not null,
    foreign key (customer_id) references netology.customers(id)
    );

insert into netology.orders(date, customer_id, product_name, amount)
values ('01.01.2024', 1, 'bag', 20),
       ('02.02.2023', 6, 'bed', 12),
       ('03.03.2022', 3, 'scarf', 123),
       ('04.04.2021', 5, 'door', 1),
       ('05.05.2020', 2, 'socks', 2),
       ('06.05.2019', 4, 'chair', 15);