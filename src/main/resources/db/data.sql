--Insert basic data into the tables

insert into employee (id, first_name, last_name, salary) values (1, 'Igor', 'Hadarin', 1000);
insert into employee (id, first_name, last_name, salary) values (2, 'John', 'Johnson', 2000);
insert into employee (id, first_name, last_name, salary) values (3, 'Mary', 'Landy', 3000);
insert into employee (id, first_name, last_name, salary) values (4, 'Alex', 'Rendall', 4000);

insert into language (id, language_name) value (1, 'C#');
insert into language (id, language_name) value (2, 'Java');
insert into language (id, language_name) value (3, '.NET');
insert into language (id, language_name) value (4, 'C++');

insert into employee_language (employee_id, language_id) values (1, 1);
insert into employee_language (employee_id, language_id) values (2, 2);
insert into employee_language (employee_id, language_id) values (3, 3);
insert into employee_language (employee_id, language_id) values (4, 4);

insert into role (role_id, role) value (1, 'USER');
insert into role (role_id, role) value (2, 'ADMIN');

--Creating user with 'ADMIN' role and password - 'qwerty'. (it has been encrypted by bcrypt). You need to enter 'qwerty' into the login page.
--Creating two users with 'USER' role and passwords: 'qwerty1', 'qwerty2'.

insert into user (user_id, active, email, last_name, name, password) values (1, 1, 'pedro@gmail.com', 'Pedrovich', 'Pedro', '$2a$10$hkOPseNKFawYYMVHWRDTju6SJNhiRHU/WBhWmCbkHqwoZnGhCUwSW');
insert into user (user_id, active, email, last_name, name, password) values (2, 1, 'user1@gmail.com', 'Kovalevski', 'Sophie', '$2a$10$k28WDX3nzhSryz4I84APSONZGypOL.bODheIyBtMdLqiGmh/iAo72');
insert into user (user_id, active, email, last_name, name, password) values (3, 1, 'user2@gmail.com', 'Bohdan', 'Rodry', '$2a$10$Fq1ZmFtOmjv0CDBobi3m0O2JAmvZBj4PlaHkZe3Pkotpu5AhBQqK.');

insert into user_role (user_id, role_id) values (1, 2);
insert into user_role (user_id, role_id) values (2, 1);
insert into user_role (user_id, role_id) values (3, 1);

