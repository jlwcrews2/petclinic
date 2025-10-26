create table if not exists pet(
    id bigint primary key,
    name varchar(50),
    pet_type varchar(10),
    owner_id bigint
);

create table if not exists owner(
    id bigint primary key,
    first_name varchar(50),
    last_name varchar(50),
    address varchar(150),
    phone varchar(30)
);

create table if not exists staff(
    id bigint primary key,
    first_name varchar(50),
    last_name varchar(50),
    staff_type varchar(10)
);

create table if not exists appointment_staff(
    appointment_id bigint,
    staff_id bigint
);

create table if not exists appointment(
    appointment_id bigint primary key,
    pet_id bigint,
    appointment_staff_id bigint,
    date timestamp
);

create sequence pet_seq start with 1 increment by 1;
create sequence staff_seq start with 1 increment by 1;
create sequence owner_seq start with 1 increment by 1;
create sequence appointment_seq start with 1 increment by 1;