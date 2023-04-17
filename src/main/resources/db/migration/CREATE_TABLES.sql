-- liquibase-formatted sql


create table if not exists student (
    id          bigint
        constraint pk_student_id primary key not null,
    first_name  varchar(240),
    last_name   varchar(240),
    deleted     boolean,
    group_id    bigint
);

create table if not exists student_group (
    id          bigint
        constraint pk_student_group_id primary key not null,
    name        varchar(240)
);

alter table student
add constraint fk_group_id foreign key (group_id) references student_group(id);

