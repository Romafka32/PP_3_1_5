create table role
(
    id   bigint auto_increment primary key,
    name varchar(255) null
);

create table user
(
    id         bigint auto_increment primary key,
    email      varchar(255) null,
    username varchar(255) null,
    last_name  varchar(255) null,
    age        tinyint not null default 0,
    password   varchar(255) null
);

create table user_role
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    constraint fk_user_role_user_id
        foreign key (user_id) references user (id),
    constraint fk_user_role_role_id
        foreign key (role_id) references role (id)
);

