create sequence discipline_sequence start 1 increment 1
GO
create sequence grade_sequence start 1 increment 1
GO
create sequence academic_group_sequence start 1 increment 1
GO
create sequence student_sequence start 1 increment 1
GO

create table academic_group (
    id bigint,
    name varchar(255),
    primary key (id)
)

GO