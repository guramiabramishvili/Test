  create table contest(
        id serial primary key not null,
        name varchar(30) not null,
        opendate Date not null,
        opentime time not null,
        duration int not null
     );