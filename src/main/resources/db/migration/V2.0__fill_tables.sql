insert into user (email, first_name, last_name, age, password) values( 'admin@ya.ru','Бока','Легендарный', 60,'$2a$12$BhV16O/lWayy8kW2nnNrCOpDzmBUJmUC1l0aL6T5YRj4MZw7lk.QK');
insert into user (email, first_name, last_name, age, password) values( 'user@mail.ru','Жока','Популярный', 28,'$2a$12$A7ya4uExmEKCNqv9ljc4O.hCbTBspywfNF5xL2JFhl9IQq2qJAsZK');

insert role (name) values ('ROLE_ADMIN');
insert role (name) values ('ROLE_USER');

insert into user_role (user_id, role_id) values((select id from user where email = 'admin@ya.ru'),
                                                (select id from role where name = 'ROLE_ADMIN'));

insert into user_role (user_id, role_id) values((select id from user where email = 'admin@ya.ru'),
                                                (select id from role where name = 'ROLE_USER'));

insert into user_role (user_id, role_id) values((select id from user where email = 'user@mail.ru'),
                                                (select id from role where name = 'ROLE_USER'));