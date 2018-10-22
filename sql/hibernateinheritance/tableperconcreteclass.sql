use mydb;

drop table payment;

create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
)

--check is a reserved work in mysql, so a personal check is represent as bankcheck 
create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
)

select * from card;

select * from bankcheck;