DROP DATABASE IF EXISTS test;

CREATE DATABASE test DEFAULT CHARACTER SET 'utf8';

USE test;

CREATE TABLE user (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(25) NOT NULL,
    age INT,
    isAdmin BIT(1) NOT NULL,
    createdDate TIMESTAMP,
    PRIMARY KEY (id)
)  ENGINE=INNODB;


set names 'utf8';

insert into user (name, age, isAdmin)
values ('Vasya', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya1', 23, 0);
insert into user (name, age, isAdmin)
values ('Vasya2', 23, 0);
insert into user (name, age, isAdmin)
values ('Vasya3', 24, 0);
insert into user (name, age, isAdmin)
values ('Vasya4', 25, 0);
insert into user (name, age, isAdmin)
values ('Vasya5', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya6', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya7', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya8', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya9', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya10', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya11', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya12', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya13', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya13', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya13', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya14', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya15', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya16', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya17', 21, 1);
insert into user (name, age, isAdmin)
values ('Vasya18', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya19', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya20', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya21', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya22', 21, 0);
insert into user (name, age, isAdmin)
values ('Vasya23', 21, 1);
insert into user (name, age, isAdmin)
values ('Vasya23', 21, 1);
insert into user (name, age, isAdmin)
values ('Vasya24', 241, 1);
insert into user (name, age, isAdmin)
values ('Vasya25', 25, 0);
insert into user (name, age, isAdmin)
values ('Vasya26', 45, 0);
insert into user (name, age, isAdmin)
values ('Vasya27', 231, 0);
insert into user (name, age, isAdmin)
values ('Vasya28', 22, 0);
insert into user (name, age, isAdmin)
values ('Vasya29', 23, 0);
insert into user (name, age, isAdmin)
values ('Vasya30', 22, 0);
insert into user (name, age, isAdmin)
values ('Коля', 22, 1);
insert into user (name, age, isAdmin)
values ('Маша', 22, 1);
insert into user (name, age, isAdmin)
values ('Маша', 24, 0);
insert into user (name, age, isAdmin)
values ('Саша', 22, 0);
insert into user (name, age, isAdmin)
values ('Ваня', 21, 0);
insert into user (name, age, isAdmin)
values ('Иннокентий Павлович', 67, 1);
insert into user (name, age, isAdmin)
values ('Петр Алексеевич', 22, 0);
insert into user (name, age, isAdmin)
values ('Дмитрий Анатольевич', 22, 0);
insert into user (name, age, isAdmin)
values ('Рамзан Ахматович', 22, 0);
