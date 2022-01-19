drop table if exists role, user, user_roles;

create table if not exists user (id bigint not null primary key auto_increment,
    first_name varchar(255) not null, last_name varchar(255) not null,
    login varchar(255) not null, password varchar(255) not null);

create table if not exists role (id int not null primary key auto_increment, role varchar(255) not null);

create table if not exists user_roles (user_id bigint, foreign key (user_id) references user(id),
    role_id int, foreign key (user_id) references user(id));

insert into user (first_name, last_name,  login, password)
values ('Anastasiya', 'Votikova', 'anastas', '$2a$10$nOfZFe84aXdvi599cUraOuP7wCszxrF161qPz1WwTxL65A/FlZolq');
insert into user (first_name, last_name,  login, password)
values ('Veronika', 'Nikishina',  'vernik', '$2a$10$XbSWcIyrf5EBdhX0EF5L6.H4EAJlatDxJrZKd49eJ32M83gZuV9Ki');
insert into role (role) values ('ADMIN'), ('USER');
insert into user_roles set user_id=(select id from user where login = 'anastas'),
    role_id = (select id from role where role = 'ADMIN');
insert into user_roles set user_id=(select id from user where login = 'vernik'),
                           role_id = (select id from role where role = 'USER');
