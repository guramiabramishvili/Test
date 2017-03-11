create table systemuser(
    id SERIAL primary key not null,
    username varchar(30) not null,
    firstname varchar(30) not null,
    lastname varchar(30) not null,
    password varchar(30) not null,
    email varchar(30) not null,
    admin boolean default false
    );