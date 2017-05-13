create table results(
    userid int references systemuser(id),
    contestid int references contest(id),
    point integer
    );